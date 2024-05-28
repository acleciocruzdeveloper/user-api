package br.com.backend.userapi.service;

import br.com.backend.userapi.domain.dto.CustomersDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ICustomersService {
    Optional<CustomersDTO> getUserByCpf(String cpf);

    ResponseEntity<List<CustomersDTO>> getCustomer();

}
