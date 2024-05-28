package br.com.backend.userapi.controller;

import br.com.backend.userapi.domain.dto.CustomersDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ICustomersController {

    @GetMapping
    public ResponseEntity<List<CustomersDTO>> getAllUser();

    @GetMapping("/{codigo}")
    public ResponseEntity<CustomersDTO> getUser(@PathVariable(value = "codigo") String cpf) throws RuntimeException;
}
