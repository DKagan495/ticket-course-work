package by.kagan.ticket.api.domain;

import by.kagan.ticket.api.enumeration.TicketStatus;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	private int number;
	
	@ManyToMany(fetch = FetchType.LAZY)
	private List<Flight> flights;
	
	private List<String> flightsIds;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	private User user;
	
	@Column(name = "fk_user")
	private String userId;
	
	@Enumerated(value = EnumType.STRING)
	private TicketStatus status;
	
	private boolean bidirectional;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	private LocalDateTime deleted;
}

