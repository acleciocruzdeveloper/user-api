package br.com.backend.customers.repositories;

import br.com.backend.customers.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomersRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByCpf(String cpf);

    boolean existsByEmail(String email);
}
