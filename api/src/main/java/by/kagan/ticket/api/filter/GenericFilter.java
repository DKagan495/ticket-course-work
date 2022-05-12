package by.kagan.ticket.api.filter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenericFilter<T extends ApiFilter> {
	private T filterInstance;
}
