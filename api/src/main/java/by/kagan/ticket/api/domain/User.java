package by.kagan.ticket.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private UUID id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	private String email;
	
	private String phone;
	
	private String login;
	
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address", insertable = false, updatable = false)
	private Address address;
	
	@Column(name = "fk_address")
	private String addressId;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	private LocalDateTime deleted;
	
}

