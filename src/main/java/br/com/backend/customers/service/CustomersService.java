package br.com.backend.customers.service;

import br.com.backend.customers.domain.Address;
import br.com.backend.customers.domain.Customers;
import br.com.backend.customers.domain.dto.CustomersDTO;
import br.com.backend.customers.domain.dto.EmailExistiException;
import br.com.backend.customers.repositories.IAddressRepository;
import br.com.backend.customers.repositories.ICustomersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomersService {
    private final ModelMapper modelMapper;
    private final ICustomersRepository repository;
    private final IAddressRepository addressRepository;

    public Optional<CustomersDTO> getCustomerByCpf(String cpf) {
        return repository.findByCpf(cpf)
                .map(this::toCustomerDTO);
    }

    public ResponseEntity<List<CustomersDTO>> getCustomer() {
        List<Customers> customers = repository.findAll();
        Stream<CustomersDTO> customersDTOStream = customers.stream().map(this::toCustomerDTO);
        return ResponseEntity.ok().body(customersDTOStream.toList());
    }

    @Transactional
    public ResponseEntity<CustomersDTO> createCustomer(CustomersDTO data) throws RuntimeException {
        try {
            if (repository.existsByEmail(data.getEmail())) {
                throw new EmailExistiException(
                        HttpStatus.BAD_REQUEST,
                        "email ja cadastrada",
                        List.of(new EmailExistiException.FieldErrors(data.getEmail())));
            }
            Customers customer = toCustomer(data);
            Address address = addressRepository.save(customer.getEndereco());
            customer.setEndereco(address);
            repository.save(customer);
            CustomersDTO mapped = modelMapper.map(customer, CustomersDTO.class);
            return ResponseEntity.ok().body(mapped);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Optional<CustomersDTO> getCustomerById(long id) {
        log.info("Fetching customer with id: {}", id);
        return repository.findById(id).map(this::toCustomerDTO)
                .or(() -> {
                    log.warn("Customer with id: {} not found", id);
                    return Optional.empty();
                });
    }

    public List<CustomersDTO> queryByName(String nome) {
        log.info("Fetching customers with name: {}", nome);
        return repository.queryByNome(nome).stream()
                .map(this::toCustomerDTO)
                .collect(Collectors.toList());
    }

    private CustomersDTO toCustomerDTO(Customers model) {
        return modelMapper.map(model, CustomersDTO.class);
    }

    private Customers toCustomer(CustomersDTO data) {
        return modelMapper.map(data, Customers.class);
    }
}
