package by.kagan.ticket.api.mapper;

import by.kagan.ticket.api.domain.Ticket;
import by.kagan.ticket.api.dto.TicketDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TicketMapper extends AbstractMapper<Ticket, TicketDto> {
	@Override
	public TicketDto map(Ticket source) {
		return TicketDto.builder()
				       .id(source.getId().toString())
				       .flightId(source.getFlightId())
				       .userId(source.getUserId())
				       .status(source.getStatus())
				       .created(ZonedDateTime.of(source.getCreated(), ZoneId.systemDefault()))
				       .updated(ZonedDateTime.of(source.getUpdated(), ZoneId.systemDefault()))
				       .deleted(ZonedDateTime.of(source.getDeleted(), ZoneId.systemDefault()))
				.build();
	}
}
