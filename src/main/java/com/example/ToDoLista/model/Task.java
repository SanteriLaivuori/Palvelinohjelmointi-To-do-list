package com.example.ToDoLista.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;
	@Column
	private String subject;
	@Column
	private String date;

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "typeid")
	private Type type;

	public Task() {
		super();

	}

	public Task(String subject, String date, Type type) {
		super();
		this.subject = subject;
		this.date = date;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		if (this.type != null)
			return "Task [id=" + id + ", subject=" + subject + ", date=" + date + ", type=" + type + this.getType()
					+ "]";
		else
			return "Task [id=" + id + ", subject=" + subject + ", date=" + date + ", type=" + type + "]";
	}

}
