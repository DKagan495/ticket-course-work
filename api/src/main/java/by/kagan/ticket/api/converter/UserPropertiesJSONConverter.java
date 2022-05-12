package by.kagan.ticket.api.converter;

import by.kagan.ticket.api.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class UserPropertiesJSONConverter implements AttributeConverter<User.UserProperties, String> {
	private final ObjectMapper mapper = new ObjectMapper();
	
	@SneakyThrows
	@Override
	public String convertToDatabaseColumn(User.UserProperties attribute) {
		return mapper.writeValueAsString(attribute);
	}
	
	@SneakyThrows
	@Override
	public User.UserProperties convertToEntityAttribute(String dbData) {
		return mapper.readValue(dbData, User.UserProperties.class);
	}
}
