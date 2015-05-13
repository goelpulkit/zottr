package com.jagoya.notify.data.maps.tables;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Defines User entity
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "USER_MESSAGE")
public class UserMessage implements Serializable {

	@Id
	@SequenceGenerator(name = "SEQ_STORE", sequenceName = "USER_MESSAGE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "USER_MESSAGE_ID", columnDefinition = "NUMBER(11)", nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "MESSAGE_ID")
	private Message message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
}
