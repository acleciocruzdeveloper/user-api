package br.com.backend.customers.repositories;

import br.com.backend.customers.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
