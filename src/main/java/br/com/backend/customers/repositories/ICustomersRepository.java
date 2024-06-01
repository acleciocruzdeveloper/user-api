package br.com.backend.customers.repositories;

import br.com.backend.customers.domain.Customers;
import br.com.backend.customers.enums.ECustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ICustomersRepository extends JpaRepository<Customers, Long> {

    Optional<Customers> findByCpf(String cpf);

    boolean existsByEmail(String email);

    List<Customers> findByStatusCustomer(ECustomerStatus status);

    List<Customers> queryByNomeLike(String name);
}
