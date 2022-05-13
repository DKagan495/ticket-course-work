package by.kagan.ticket.api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
public class UserDto {
	private String id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private String email;
	
	private String addressId;
	
	private ZonedDateTime created;
	
	private ZonedDateTime updated;
	
	private ZonedDateTime deleted;
}
