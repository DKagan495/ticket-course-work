package by.kagan.ticket.api.controller;

import by.kagan.ticket.api.dto.FlightDto;
import by.kagan.ticket.api.dto.UserDto;
import by.kagan.ticket.api.mapper.FlightMapper;
import by.kagan.ticket.api.request.user.CreateUserRequest;
import by.kagan.ticket.api.request.user.SearchUserRequest;
import by.kagan.ticket.api.request.user.UpdateUserRequest;
import by.kagan.ticket.api.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightEndpoint {
	private final FlightService flightService;
	
	private final FlightMapper flightMapper;
	
	@GetMapping("/getById")
	public ResponseEntity<FlightDto> getById(@RequestParam String id) {
		var target = flightMapper.map(flightService.fetchById(id))
		
		return ResponseEntity.ok(target);
	}
	
	@GetMapping("/getByIds")
	public ResponseEntity<Iterable<FlightDto>> getByIds(@RequestParam List<String> ids) {
		var target = flightMapper.map(flightService.fetchByIds(ids));
		
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
