package br.com.backend.userapi.repositories;

import br.com.backend.userapi.domain.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomersRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> getUserByCpf(String cpf);

    boolean existsByEmail(String email);
}
