package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.Airport;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.AirportFilter;
import by.kagan.ticket.api.repository.AirportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AirportService implements ApiService<Airport> {
	
	private final AirportRepository airportRepository;
	
	@Override
	public Airport fetchById(String id) {
		return airportRepository.findById(id).orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
	}
	
	@Override
	public Iterable<Airport> fetchByIds(Iterable<String> ids) {
		return airportRepository.findAllById(ids);
	}
	
	public Page<Airport> fetchByFilter(AirportFilter filter, Pageable pageable) {
		return null;
	}
	
	@Override
	public Airport create(Airport entity) {
		return airportRepository.save(entity);
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
