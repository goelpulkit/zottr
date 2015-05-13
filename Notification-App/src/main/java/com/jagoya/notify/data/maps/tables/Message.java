package com.jagoya.notify.data.maps.tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.jagoya.notify.data.maps.enums.MessageType;
import com.jagoya.notify.data.maps.enums.Status;

/**
 * Defines Message entity
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "MESSAGE")
public class Message implements Serializable {

	@Id
	@SequenceGenerator(name = "SEQ_STORE", sequenceName = "MESSAGE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "MESSAGE_ID", columnDefinition = "NUMBER(11)", nullable = false)
	private long id;

	@Column(name = "SUBJECT", columnDefinition = "VARCHAR(100)", nullable = false)
	private String subject;

	@Column(name = "CONTENT", columnDefinition = "VARCHAR(500)", nullable = true)
	private String content;

	@Column(name = "SEND_DATE", columnDefinition = "DATE", nullable = false)
	private Date sendDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", columnDefinition = "VARCHAR(20) DEFAULT 'ALL'", nullable = false)
	private MessageType type;

	@OneToMany(mappedBy = "message", fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Set<UserMessage> userMessages;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "VARCHAR(8) DEFAULT 'ACTIVE'", nullable = false)
	private Status status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Set<UserMessage> getUserMessages() {
		return userMessages;
	}

	public void setUserMessages(Set<UserMessage> userMessages) {
		this.userMessages = userMessages;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
