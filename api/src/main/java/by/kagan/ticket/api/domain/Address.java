package by.kagan.ticket.api.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
public class Address {
	
	@Id
	@GeneratedValue
	private UUID id;
	
	private String country;
	
	private String region;
	
	private String city;
	
	private String street;
	
	private String building;
	
	private String flat;
	
	private
}
