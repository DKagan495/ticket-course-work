package by.kagan.ticket.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class AirportDto {
	private String id;
	
	private String name;
	
	private String description;
	
	private String addressId;
	
	private ZonedDateTime created;
	
	private ZonedDateTime updated;
	
	private ZonedDateTime deleted;

}
