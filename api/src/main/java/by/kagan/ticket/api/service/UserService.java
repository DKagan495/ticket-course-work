package by.kagan.ticket.api.service;

import by.kagan.ticket.api.domain.User;
import by.kagan.ticket.api.enumeration.ErrorStatusCode;
import by.kagan.ticket.api.exception.ApiException;
import by.kagan.ticket.api.filter.UserFilter;
import by.kagan.ticket.api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService implements ApiService<User> {
	
	private final UserRepository userRepository;
	
	@Override
	public User fetchById(String id) {
		return userRepository.findById(id).orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
	}
	
	@Override
	public Iterable<User> fetchByIds(Iterable<String> ids) {
		return userRepository.findAllById(ids);
	}
	
	public Page<User> fetchByFilter(UserFilter filter, Pageable pageable) {
		return null;
	}
	
	@Override
	public User create(User entity) {
		return userRepository.save(entity);
	}
	
	@Override
	public User update(User entity) {
		var old = userRepository.findById(entity.getId().toString());
		
		old.orElseThrow(() -> new ApiException(ErrorStatusCode.OBJECT_NOT_FOUND));
		
		return userRepository.save(build(old.get(), entity));
	}
	
	@Override
	public void delete(String id) {
		userRepository.findById(id).ifPresent((user -> {
			user.setDeleted(LocalDateTime.now());
			userRepository.save(user);
		}));
	}
	
	private User build(User old, User updated) {
		old.setAddress(updated.getAddress());
		old.setBirthDate(updated.getBirthDate());
		old.setEmail(updated.getEmail());
		old.setFirstName(updated.getFirstName());
		old.setMiddleName(updated.getMiddleName());
		old.setLastName(updated.getLastName());
		
		return old;
		
	}
}
