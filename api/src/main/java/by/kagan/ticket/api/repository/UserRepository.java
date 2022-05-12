package by.kagan.ticket.api.repository;

import by.kagan.ticket.api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
