package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.Ticket;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import by.kagan.ticket.api.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TicketService implements ApiService<Ticket> {
	
	private final TicketRepository ticketRepository;
	
	@Override
	public Ticket fetchById(String id) {
		return null;
	}
	
	@Override
	public Set<Ticket> fetchByIds(Set<String> ids) {
		return null;
	}
	
	@Override
	public <T extends ApiFilter> Page<Ticket> fetchByFilter(GenericFilter<T> filter, Pageable pageable) {
		return null;
	}
	
	@Override
	public Ticket create(Ticket entity) {
		return ticketRepository.save(entity);
	}
	
	@Override
	public Ticket update(Ticket entity) {
		var old = ticketRepository.findById(entity.getId().toString());
		
		old.orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
		
		return ticketRepository.save(build(old.get(), entity));
	}
	
	@Override
	public void delete(String id) {
		ticketRepository.findById(id).ifPresent((ticket -> {
			ticket.setDeleted(LocalDateTime.now());
			ticketRepository.save(ticket);
		}));
	}
	
	public Ticket build(Ticket old, Ticket updated){
		old.setUser(updated.getUser());
		old.setFlights(updated.getFlights());
		old.setNumber(updated.getNumber());
		old.setStatus(updated.getStatus());
		old.setBidirectional(updated.isBidirectional());
		
		return old;
	}
}
