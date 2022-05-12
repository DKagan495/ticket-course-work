package by.kagan.ticket.api.service;

import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

public interface ApiService<E> {
	E fetchById(String id);
	
	Set<E> fetchByIds(Set<String> ids);
	
	<T extends ApiFilter> Page<E> fetchByFilter(GenericFilter<T> filter, Pageable pageable);
	
	E create(E entity);
	
	E update(E entity);
	
	void delete(String id);
}
