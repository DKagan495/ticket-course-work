package by.kagan.ticket.api.repository;

import by.kagan.ticket.api.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {
}
