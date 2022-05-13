package by.kagan.ticket.api.controller;

import by.kagan.ticket.api.dto.UserDto;
import by.kagan.ticket.api.request.user.CreateUserRequest;
import by.kagan.ticket.api.request.user.DeleteUserRequest;
import by.kagan.ticket.api.request.user.SearchUserRequest;
import by.kagan.ticket.api.request.user.UpdateUserRequest;
import by.kagan.ticket.api.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class AddressEndpoint {
	
	private final AddressService addressService;
	
	@GetMapping("/getById")
	public ResponseEntity<UserDto> getById(@RequestParam String id) {
		return null;
	}
	
	@GetMapping("/getByIds")
	public ResponseEntity<List<UserDto>> getByIds(@RequestParam List<String> ids) {
		return null;
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
	
	@PostMapping("/delete")
	public ResponseEntity<HttpStatus> delete(@RequestBody @Valid DeleteUserRequest request) {
		return ResponseEntity.ok(HttpStatus.OK);
	}
}
