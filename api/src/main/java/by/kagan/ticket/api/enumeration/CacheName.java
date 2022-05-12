package by.kagan.ticket.api.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CacheName {
	USERS("users"),
	FLIGHTS("flights"),
	TICKETS("tickets"),
	AIRPORTS("airports"),
	ADDRESSES("addresses");
	
	private final String name;
}
