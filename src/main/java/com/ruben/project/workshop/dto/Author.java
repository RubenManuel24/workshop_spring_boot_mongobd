package com.ruben.project.workshop.dto;

import java.io.Serializable;
import java.util.Objects;

import com.ruben.project.workshop.domain.User;

public class Author implements Serializable{
	
	private String id;
	private String name;
	
	public Author() {}
	
	public Author(User user) {
		this.id = user.getId();
		this.name = user.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}
