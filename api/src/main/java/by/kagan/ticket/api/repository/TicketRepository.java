package by.kagan.ticket.api.repository;

import by.kagan.ticket.api.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
