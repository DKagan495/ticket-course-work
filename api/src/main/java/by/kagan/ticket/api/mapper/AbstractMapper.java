package by.kagan.ticket.api.mapper;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMapper<E1, E2> {
	
	public abstract E2 map(E1 source);
	
	public Iterable<E2> map(Iterable<E1> sources) {
		var target = new ArrayList<E2>();
		
		for (E1 source : sources) {
			target.add(map(source));
		}
		
		return target;
	}
}
