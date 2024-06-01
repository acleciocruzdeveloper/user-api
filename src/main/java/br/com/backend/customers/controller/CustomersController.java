package br.com.backend.customers.controller;

import br.com.backend.customers.domain.dto.CustomersDTO;
import br.com.backend.customers.service.CustomersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CustomersController {

    private final CustomersService service;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
        log.info("get all customers");
        List<CustomersDTO> dtoList = service.getCustomer();
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping("/customers/cpf/{cpf}")
    public ResponseEntity<CustomersDTO> searchByCpf(@PathVariable String cpf) {
        log.info("search customer by document");
        return service.getCustomerByCpf(cpf)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> new RuntimeException("Customer not found!"));

    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomersDTO> createdCustomer(@RequestBody CustomersDTO data) {
        log.info("created customer");
        return service.createCustomer(data);
    }

    @GetMapping("/customers/id/{id}")
    public ResponseEntity<CustomersDTO> customerById(@PathVariable long id) {
        return service.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/customers/search")
    public ResponseEntity<List<CustomersDTO>> searchByName(@RequestParam String name) {
        List<CustomersDTO> customersDTOS = service.queryByName(name);
        return ResponseEntity.ok().body(customersDTOS);
    }

    @PatchMapping("/customers/inactive/{id}")
    public ResponseEntity<Void> inactiveCustomer(@PathVariable long id) {
        try {
            service.inactiveCustomer(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

}
