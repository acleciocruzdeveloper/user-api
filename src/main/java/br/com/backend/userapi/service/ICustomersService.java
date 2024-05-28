package br.com.backend.userapi.service;

import br.com.backend.userapi.domain.dto.CustomersDTO;

import java.util.Optional;

public interface ICustomersService {
    Optional<CustomersDTO> getUserByCpf(String cpf);
}
