package by.kagan.ticket.api.controller;

import by.kagan.ticket.api.dto.UserDto;
import by.kagan.ticket.api.mapper.UserMapper;
import by.kagan.ticket.api.repository.UserRepository;
import by.kagan.ticket.api.request.user.CreateUserRequest;
import by.kagan.ticket.api.request.user.DeleteUserRequest;
import by.kagan.ticket.api.request.user.SearchUserRequest;
import by.kagan.ticket.api.request.user.UpdateUserRequest;
import by.kagan.ticket.api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserEndpoint {
	
	private final UserService userService;
	
	private final UserMapper userMapper;
	
	@GetMapping("/getById")
	public ResponseEntity<UserDto> getById(@RequestParam String id) {
		var target = userMapper.map(userService.fetchById(id));
		
		return ResponseEntity.ok(target);
	}
	
	@GetMapping("/getByIds")
	public ResponseEntity<Iterable<UserDto>> getByIds(@RequestParam List<String> ids) {
		var target = userMapper.map(userService.fetchByIds(ids));
		
		return ResponseEntity.ok(target);
	}
	
	@PostMapping("/getByFilter")
	public ResponseEntity<List<UserDto>> getByFilter(@RequestBody @Valid SearchUserRequest request, @PageableDefault Pageable pageable) {
		return null;
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserRequest request) {
		
		
		return ;
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserDto> update(@RequestBody @Valid UpdateUserRequest request) {
	
	}}
}
