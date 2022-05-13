package by.kagan.ticket.api.mapper;

import by.kagan.ticket.api.domain.User;
import by.kagan.ticket.api.dto.UserDto;
import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class UserMapper extends AbstractMapper<User, UserDto> {
	
	@Override
	public UserDto map(User source) {
		return UserDto.builder()
				.id(source.getId().toString())
				       .firstName(source.getFirstName())
				       .middleName(source.getMiddleName())
				       .lastName(source.getLastName())
				       .email(source.getEmail())
				       .created(ZonedDateTime.of(source.getCreated(), ZoneId.systemDefault()))
				       .updated(ZonedDateTime.of(source.getUpdated(), ZoneId.systemDefault()))
				       .addressId(source.getAddressId())
				       .deleted(source.getDeleted() != null ? ZonedDateTime.of(source.getDeleted(), ZoneId.systemDefault()) : null)
				.build();
	}

}
