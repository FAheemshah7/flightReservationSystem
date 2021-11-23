package com.flightReservationSystem.entity;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLE")
public class Role extends AbstractEntity implements GrantedAuthority {
	
	private String name;
	
	@ManyToMany (mappedBy="roles")
	private Set<User> user;

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	@Override
	public String getAuthority() {
		return name;
	} 
	@Override
	public String toString() {
		return "Role [name=" + name + ", user=" + user + "]";
	}



}
