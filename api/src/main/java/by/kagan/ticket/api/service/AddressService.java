package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.Address;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.AddressFilter;
import by.kagan.ticket.api.filter.ApiFilter;
import by.kagan.ticket.api.filter.GenericFilter;
import by.kagan.ticket.api.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AddressService implements ApiService<Address> {
	
	private final AddressRepository addressRepository;
	
	@Override
	public Address fetchById(String id) {
		return addressRepository.findById(id).orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
	}
	
	@Override
	public Iterable<Address> fetchByIds(Iterable<String> ids) {
		return addressRepository.findAllById(ids);
	}
	
	Page<Address> fetchByFilter(AddressFilter filter, Pageable pageable) {
		return null;
	}
	
	@Override
	public Address create(Address entity) {
		return addressRepository.save(entity);
	}
	
	@Override
	public Address update(Address entity) {
		return null;
	}
	
	@Override
	public void delete(String id) {
		addressRepository.findById(id).ifPresent((address -> {
			address.setDeleted(LocalDateTime.now());
			addressRepository.save(address);
		}));
	}
	
	private Address build(Address old, Address updated) {
		old.setCountry(updated.getCountry());
		old.setRegion(updated.getRegion());
		old.setCity(updated.getCity());
		old.setStreet(updated.getStreet());
		old.setBuilding(updated.getBuilding());
		old.setFlat(updated.getFlat());
		
		return old;
	}
}
