package by.kagan.ticket.api.repository;

import by.kagan.ticket.api.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, String> {
}
