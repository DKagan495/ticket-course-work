package by.kagan.ticket.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Airport {
	@Id
	@GeneratedValue
	private UUID id;
	
	private String name;
	
	private String description;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address", insertable = false, updatable = false)
	private Address address;
	
	@Column(name = "fk_address")
	private String addressId;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	private LocalDateTime deleted;
}
