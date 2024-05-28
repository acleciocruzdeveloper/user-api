package br.com.backend.userapi.service.impl;

import br.com.backend.userapi.domain.Customers;
import br.com.backend.userapi.domain.dto.CustomersDTO;
import br.com.backend.userapi.repositories.CustomersRepository;
import br.com.backend.userapi.service.ICustomersService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
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

    private CustomersDTO toUserDto(Customers model){
        return modelMapper.map(model, CustomersDTO.class);
    }
}
