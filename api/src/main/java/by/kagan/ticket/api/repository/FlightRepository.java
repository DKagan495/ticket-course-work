package by.kagan.ticket.api.repository;

import by.kagan.ticket.api.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, String> {
}
