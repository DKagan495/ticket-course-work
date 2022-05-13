package by.kagan.ticket.api.service;

import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ApiService<E> {
	E fetchById(String id);
	
	Iterable<E> fetchByIds(Iterable<String> ids);
	
	E create(E entity);
	
	E update(E entity);
	
	void delete(String id);
}
