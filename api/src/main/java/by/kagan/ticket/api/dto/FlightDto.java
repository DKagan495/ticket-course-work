package by.kagan.ticket.api.dto;

import by.kagan.ticket.api.enumeration.FlightStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class FlightDto {
	
	private String id;
	
	private String airportFromId;
	
	private String airportToId;
	
	private ZonedDateTime arrival;
	
	private ZonedDateTime departure;
	
	private FlightStatus status;
	
	private ZonedDateTime created;
	
	private ZonedDateTime updated;
	
	private ZonedDateTime deleted;
	
	private BigDecimal cost;
	
	private byte places;
}
