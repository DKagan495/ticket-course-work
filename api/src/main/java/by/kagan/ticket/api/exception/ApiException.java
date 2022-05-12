package by.kagan.ticket.api.exception;

import by.kagan.ticket.api.enumeration.ErrorStatusCode;

public class ApiException extends RuntimeException {
	public ApiException(ErrorStatusCode code) {
		super(code.getMessage());
	}
	
	public ApiException(ErrorStatusCode code, String entityId) {
		super(code.getMessage());
	}
}
