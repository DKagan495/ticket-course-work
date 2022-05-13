package by.kagan.ticket.api.controller;

import by.kagan.ticket.api.dto.AirportDto;
import by.kagan.ticket.api.dto.UserDto;
import by.kagan.ticket.api.mapper.AirportMapper;
import by.kagan.ticket.api.request.user.CreateUserRequest;
import by.kagan.ticket.api.request.user.SearchUserRequest;
import by.kagan.ticket.api.request.user.UpdateUserRequest;
import by.kagan.ticket.api.service.AirportService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AirportEndpoint {
	private final AirportService airportService;
	
	private final AirportMapper airportMapper;
	
	@GetMapping("/getById")
	public ResponseEntity<AirportDto> getById(@RequestParam String id) {
		var target = airportMapper.map(airportService.fetchById(id));
		
		return ResponseEntity.ok(target);
	}
	
	@GetMapping("/getByIds")
	public ResponseEntity<Iterable<UserDto>> getByIds(@RequestParam List<String> ids) {
		var target = airportMapper.map(airportService.fetchByIds(ids));
		
		return ResponseEntity.ok(target);
	}
	
	@PostMapping("/getByFilter")
	public ResponseEntity<List<UserDto>> getByFilter(@RequestBody @Valid SearchUserRequest request, @PageableDefault Pageable pageable) {
		return null;
	}
	
	@PostMapping("/create")
	public ResponseEntity<UserDto> create(@RequestBody @Valid CreateUserRequest request) {
		return null;
	}
	
	@PostMapping("/update")
	public ResponseEntity<UserDto> update(@RequestBody @Valid UpdateUserRequest request) {
	
	}
}
