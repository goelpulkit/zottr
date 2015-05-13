package com.jagoya.notify.data.maps.tables;

import java.io.Serializable;
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

import org.hibernate.annotations.Check;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.jagoya.notify.data.maps.enums.Status;

/**
 * Defines Course entity
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "COURSE")
@Check(constraints = "TYPE in ('ONLINE', 'CLASSROOM', 'BOTH')")
public class Course implements Serializable {

	@Id
	@SequenceGenerator(name = "SEQ_STORE", sequenceName = "COURSE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "COURSE_ID", columnDefinition = "NUMBER(11)", nullable = false)
	private long id;

	@Column(name = "NAME", columnDefinition = "VARCHAR(50)", nullable = false)
	private String name;

	@Column(name = "DURATION_IN_DAYS", columnDefinition = "NUMBER(3)", nullable = true)
	private String durationInDays;

	@Column(name = "FEE", columnDefinition = "NUMBER(6)", nullable = false)
	private String fee;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", columnDefinition = "VARCHAR(10) DEFAULT 'CLASSROOM'", nullable = false)
	private String type;

	@OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
	@Fetch(FetchMode.JOIN)
	private Set<UserCourse> userCourses;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", columnDefinition = "VARCHAR(8) DEFAULT 'ACTIVE'", nullable = false)
	private Status status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDurationInDays() {
		return durationInDays;
	}

	public void setDurationInDays(String durationInDays) {
		this.durationInDays = durationInDays;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(Set<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
