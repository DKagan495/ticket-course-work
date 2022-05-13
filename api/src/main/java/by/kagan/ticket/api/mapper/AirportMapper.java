package by.kagan.ticket.api.mapper;

import by.kagan.ticket.api.domain.Airport;
import by.kagan.ticket.api.dto.AirportDto;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class AirportMapper extends AbstractMapper<Airport, AirportDto> {
	@Override
	public AirportDto map(Airport source) {
		return AirportDto.builder()
				.id(source.getId().toString())
				.name(source.getName())
				.description(source.getDescription())
				.addressId(source.getAddressId())
				.created(ZonedDateTime.of(source.getCreated(), ZoneId.systemDefault()))
				.updated(ZonedDateTime.of(source.getUpdated(), ZoneId.systemDefault()))
				.deleted(source.getDeleted() != null ? ZonedDateTime.of(source.getDeleted(), ZoneId.systemDefault()) : null)
				.build();
	}
}
