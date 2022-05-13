package by.kagan.ticket.api.mapper;

import by.kagan.ticket.api.domain.Flight;
import by.kagan.ticket.api.dto.FlightDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class FlightMapper extends AbstractMapper<Flight, FlightDto> {
	@Override
	public FlightDto map(Flight source) {
		return FlightDto.builder()
				.id(source.getId().toString())
				.airportFromId(source.getAirportFromId())
				.airportToId(source.getAirportToId())
				.arrival(ZonedDateTime.of(source.getArrival(), ZoneId.systemDefault()))
				.departure(ZonedDateTime.of(source.getDeparture(), ZoneId.systemDefault()))
				.status(source.getStatus())
				.places(source.getPlaces())
				.cost(source.getCost())
				.created(ZonedDateTime.of(source.getCreated(), ZoneId.systemDefault()))
				.updated(ZonedDateTime.of(source.getUpdated(), ZoneId.systemDefault()))
				.deleted(source.getDeleted() != null ? ZonedDateTime.of(source.getDeleted(), ZoneId.systemDefault()) : null)
				.build();
	}
}
