package by.kagan.ticket.api.domain;

import by.kagan.ticket.api.converter.UserPropertiesJSONConverter;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
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
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	private String firstName;
	
	private String middleName;
	
	private String lastName;
	
	private LocalDate birthDate;
	
	private String email;
	
	private String phone;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fk_address", insertable = false, updatable = false)
	private Address address;
	
	@Column(name = "fk_address")
	private String addressId;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	private LocalDateTime deleted;
	
}

