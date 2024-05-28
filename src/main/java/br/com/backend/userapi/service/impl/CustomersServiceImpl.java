package br.com.backend.userapi.service.impl;

import br.com.backend.userapi.domain.Customers;
import br.com.backend.userapi.domain.dto.CustomersDTO;
import br.com.backend.userapi.repositories.CustomersRepository;
import br.com.backend.userapi.service.ICustomersService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomersServiceImpl implements ICustomersService {
    private final ModelMapper modelMapper;
    private final CustomersRepository repository;

    public CustomersServiceImpl(ModelMapper modelMapper, CustomersRepository repository) {
        this.modelMapper = modelMapper;
        this.repository = repository;
    }

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

    private CustomersDTO toUserDto(Customers model) {
        return modelMapper.map(model, CustomersDTO.class);
    }
}
