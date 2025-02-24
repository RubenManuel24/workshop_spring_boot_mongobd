package com.ruben.project.workshop.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CommentDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String text;
	private AuthorDTO authorDTO;
	
	public CommentDTO() {}

	public CommentDTO(String id, Date date, String text, AuthorDTO authorDTO) {
		super();
		this.id = id;
		this.date = date;
		this.text = text;
		this.authorDTO = authorDTO;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public AuthorDTO getAuthor() {
		return authorDTO;
	}

	public void setAuthor(AuthorDTO author) {
		this.authorDTO = author;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentDTO other = (CommentDTO) obj;
		return Objects.equals(id, other.id);
	}


}
