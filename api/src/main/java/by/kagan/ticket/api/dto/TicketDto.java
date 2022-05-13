package by.kagan.ticket.api.dto;

import by.kagan.ticket.api.enumeration.TicketStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class TicketDto {
	private String id;
	
	private String flightId;
	
	private String userId;
	
	private TicketStatus status;
	
	private ZonedDateTime created;
	
	private ZonedDateTime updated;
	
	private ZonedDateTime deleted;
}
