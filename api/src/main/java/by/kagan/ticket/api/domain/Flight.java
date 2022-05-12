package by.kagan.ticket.api.domain;

import by.kagan.ticket.api.enumeration.FlightStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
public class Flight {
	@Id
	@GeneratedValue
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_airport_from", insertable = false, updatable = false)
	private Airport airportFrom;
	
	@Column(name = "fk_airport_from")
	private String airportFromId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_airport_to", insertable = false, updatable = false)
	private Airport airportTo;
	
	@Column(name = "fk_airport_to")
	private String airportToId;
	
	@Enumerated(value = EnumType.STRING)
	private FlightStatus status;
	
	private LocalDateTime arrival;
	
	private LocalDateTime departure;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	private LocalDateTime deleted;
	
	private BigDecimal cost;
	
	private byte places;
	
	@PreUpdate
	@PrePersist
	private void setCreated() {
		this.created = LocalDateTime.now();
		this.updated = LocalDateTime.now();
	}
	
	public void setAirportFrom(Airport airportFrom) {
		this.airportFrom = airportFrom;
		this.airportFromId = airportFrom != null ? airportFrom.getId().toString() : null;
	}
	
	public void setAirportTo(Airport airportTo) {
		this.airportTo = airportTo;
		this.airportToId = airportTo != null ? airportTo.getId().toString() : null;
	}
}
