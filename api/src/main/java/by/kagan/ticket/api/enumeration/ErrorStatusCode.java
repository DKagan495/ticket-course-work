package by.kagan.ticket.api.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorStatusCode {
	
	USER_NOT_FOUND(100, "Пользователь {} не найден"),
	OBJECT_NOT_FOUND(101, "Объект не найден");
	
	private int code;
	private String message;
}
