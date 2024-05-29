package br.com.backend.userapi.controller.impl;

import br.com.backend.userapi.controller.ICustomersController;
import br.com.backend.userapi.domain.dto.CustomersDTO;
import br.com.backend.userapi.service.ICustomersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomersControllerImpl implements ICustomersController {

    private final ICustomersService service;

    @Override
    public ResponseEntity<List<CustomersDTO>> getAllUser() {
        log.info("get all customers");
        return service.getCustomer();
    }

    @Override
    public ResponseEntity<CustomersDTO> getUser(String cpf) {
        log.info("search customer by document");
        return service.getUserByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));

    }

    @Override
    public ResponseEntity<CustomersDTO> createdCustomer(CustomersDTO data) {
        log.info("created customer");
        return service.createCustomer(data);
    }

}
