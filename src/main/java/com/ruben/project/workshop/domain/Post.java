package com.ruben.project.workshop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.ruben.project.workshop.dto.AuthorDTO;
import com.ruben.project.workshop.dto.CommentDTO;

@Document
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDTO authorDto;
	
	private List<CommentDTO> listComments = new ArrayList<>();
	
	public Post(){}

	public Post(String id, Date date, String title, String body, AuthorDTO authorDto) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.authorDto = authorDto;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public AuthorDTO getAuthor() {
		return authorDto;
	}

	public void setAuthor(AuthorDTO user) {
		this.authorDto = user;
	}
	
	public List<CommentDTO> getListComments() {
		return listComments;
	}

	public void setListComments(List<CommentDTO> listComments) {
		this.listComments = listComments;
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
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	

}
