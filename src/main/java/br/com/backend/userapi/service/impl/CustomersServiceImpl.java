package br.com.backend.userapi.service.impl;

import br.com.backend.userapi.domain.Address;
import br.com.backend.userapi.domain.Customers;
import br.com.backend.userapi.domain.dto.CustomersDTO;
import br.com.backend.userapi.domain.dto.EmailExistiException;
import br.com.backend.userapi.repositories.CustomersRepository;
import br.com.backend.userapi.repositories.IAddressRepository;
import br.com.backend.userapi.service.ICustomersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements ICustomersService {
    private final ModelMapper modelMapper;
    private final CustomersRepository repository;
    private final IAddressRepository addressRepository;

    @Override
    public Optional<CustomersDTO> getUserByCpf(String cpf) {
        return repository.getUserByCpf(cpf).map(this::toUserDto);
    }

    @Override
    public ResponseEntity<List<CustomersDTO>> getCustomer() {
        List<Customers> customers = repository.findAll();
        Stream<CustomersDTO> customersDTOStream = customers.stream().map(this::toUserDto);
        return ResponseEntity.ok().body(customersDTOStream.toList());
    }

    @Override
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

    private CustomersDTO toUserDto(Customers model) {
        return modelMapper.map(model, CustomersDTO.class);
    }

    private Customers toCustomer(CustomersDTO data) {
        return modelMapper.map(data, Customers.class);
    }
}
