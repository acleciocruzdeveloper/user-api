package br.com.backend.userapi.controller.impl;

import br.com.backend.userapi.controller.ICustomersController;
import br.com.backend.userapi.domain.dto.CustomersDTO;
import br.com.backend.userapi.service.ICustomersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomersControllerImpl implements ICustomersController {

    private final ICustomersService service;

    public CustomersControllerImpl(ICustomersService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<List<CustomersDTO>> getAllUser() {
        return null;
    }

    @Override
    public ResponseEntity<CustomersDTO> getUser(String cpf) {
        Optional<CustomersDTO> userByCpf = service.getUserByCpf(cpf);
        return ResponseEntity.ok().body(userByCpf.get());
    }

}
