package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.Airport;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import by.kagan.ticket.api.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AirportService implements ApiService<Airport> {
	
	private final AirportRepository airportRepository;
	
	@Override
	public Airport fetchById(String id) {
		return null;
	}
	
	@Override
	public Set<Airport> fetchByIds(Set<String> ids) {
		return null;
	}
	
	@Override
	public <T extends ApiFilter> Page<Airport> fetchByFilter(GenericFilter<T> filter, Pageable pageable) {
		return null;
	}
	
	@Override
	public Airport create(Airport entity) {
		return null;
	}
	
	@Override
	public Airport update(Airport entity) {
		var old = airportRepository.findById(entity.getId().toString());
		
		old.orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
		
		return airportRepository.save(build(old.get(), entity));
	}
	
	@Override
	public void delete(String id) {
		airportRepository.findById(id).ifPresent((airport -> {
			airport.setDeleted(LocalDateTime.now());
			airportRepository.save(airport);
		}));
	}
	
	public Airport build(Airport old, Airport updated) {
		old.setAddress(updated.getAddress());
		old.setDescription(updated.getDescription());
		old.setName(updated.getName());
		
		return old;
	}
}
