package br.com.backend.userapi.repositories;

import br.com.backend.userapi.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressRepository extends JpaRepository<Address, Long> {
}
