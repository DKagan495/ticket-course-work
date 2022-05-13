package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.Flight;
import by.kagan.ticket.api.enumeration.CacheName;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.FlightFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import by.kagan.ticket.api.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Cache;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FlightService implements ApiService<Flight> {
	
	private final FlightRepository flightRepository;
	
	@Override
	@Cacheable(value = CacheName.FLIGHTS.getName())
	public Flight fetchById(String id) {
		return flightRepository.findById(id).orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
	}
	
	@Override
	@Cacheable(value = CacheName.FLIGHTS.getName())
	public Iterable<Flight> fetchByIds(Iterable<String> ids) {
		return flightRepository.findAllById(ids);
	}
	
	 Page<Flight> fetchByFilter(FlightFilter filter, Pageable pageable) {
		return null;
	}
	
	@Override
	@Transactional
	public Flight create(Flight entity) {
		return flightRepository.save(entity);
	}
	
	@Override
	@Transactional
	public Flight update(Flight entity) {
		var old = flightRepository.findById(entity.getId().toString());
		
		old.orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
		
		return flightRepository.save(build(old.get(), entity));
	}
	
	@Override
	@Transactional
	public void delete(String id) {
		flightRepository.findById(id).ifPresent((flight -> {
			flight.setDeleted(LocalDateTime.now());
			flightRepository.save(flight);
		}));
	}
	
	private Flight build(Flight old, Flight updated) {
		old.setAirportFrom(updated.getAirportFrom());
		old.setAirportTo(updated.getAirportTo());
		old.setArrival(updated.getArrival());
		old.setDeparture(updated.getDeparture());
		old.setCost(updated.getCost());
		old.setStatus(updated.getStatus());
		old.setPlaces(updated.getPlaces());
		
		return old;
	}
}
