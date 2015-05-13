package com.jagoya.notify.data.maps.tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
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

import com.jagoya.notify.data.maps.enums.Gender;
import com.jagoya.notify.data.maps.enums.Status;
import com.jagoya.notify.data.maps.enums.UserType;

/**
 * Defines User entity
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "USER")
@Check(constraints = "GENDER in ('MALE', 'FEMALE', 'UNDEFINED')")
public class User implements Serializable {

	@Id
	@SequenceGenerator(name = "SEQ_STORE", sequenceName = "USER_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "USER_ID", columnDefinition = "NUMBER(11)", nullable = false)
	private long id;

	@Column(name = "FIRST_NAME", columnDefinition = "VARCHAR(20)", nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", columnDefinition = "VARCHAR(20)", nullable = true)
	private String lastName;

	@Column(name = "EMAIL_ID", columnDefinition = "VARCHAR(50)", nullable = false)
	private String emailId;

	@Column(name = "CONTACT_NUMBER", columnDefinition = "VARCHAR(14)", nullable = false)
	private String contactNumber;

	@Column(name = "DOB", columnDefinition = "DATE", nullable = false)
	private Date dataOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(name = "GENDER", columnDefinition = "VARCHAR(10) DEFAULT 'UNDEFINED'", nullable = false)
	private Gender gender;

	@Enumerated(EnumType.STRING)
	@Column(name = "TYPE", columnDefinition = "VARCHAR(20) DEFAULT 'PROSPECT_STUDENT'", nullable = false)
	private UserType type;

	@Column(name = "COUNTRY", columnDefinition = "VARCHAR(100)", nullable = true)
	private String country;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getDataOfBirth() {
		return dataOfBirth;
	}

	public void setDataOfBirth(Date dataOfBirth) {
		this.dataOfBirth = dataOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public UserType getType() {
		return type;
	}

	public void setType(UserType type) {
		this.type = type;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<UserCourse> getUserCourses() {
		return userCourses;
	}

	public void setUserCourses(Set<UserCourse> userCourses) {
		this.userCourses = userCourses;
	}

	public void addUserCourse(UserCourse userCourse) {
		if (this.userCourses == null) {
			this.userCourses = new HashSet<UserCourse>();
		}
		this.userCourses.add(userCourse);
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
