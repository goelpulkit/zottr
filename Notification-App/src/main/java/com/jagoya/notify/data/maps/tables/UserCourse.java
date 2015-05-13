package com.jagoya.notify.data.maps.tables;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

import com.jagoya.notify.data.maps.enums.Gender;
import com.jagoya.notify.data.maps.enums.UserType;

/**
 * Defines User entity
 * 
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "USER_COURSE")
@Check(constraints = "COURSE_TYPE in ('ONLINE', 'CLASSROOM', 'BOTH')")
public class UserCourse implements Serializable {

	@Id
	@SequenceGenerator(name = "SEQ_STORE", sequenceName = "USER_COURSE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_STORE")
	@Column(name = "USER_COURSE_ID", columnDefinition = "NUMBER(11)", nullable = false)
	private long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "COURSE_ID")
	private Course course;

	@Column(name = "START_DATE", columnDefinition = "DATE", nullable = false)
	private String startDate;

	@Column(name = "END_PAID", columnDefinition = "DATE", nullable = false)
	private String endDate;

	@Column(name = "FEE_PAID", columnDefinition = "NUMBER(6) DEFAULT 0", nullable = false)
	private Date feePaid;

	@Column(name = "COURSE_FEE", columnDefinition = "NUMBER(6) DEFAULT 0", nullable = false)
	private Gender courseFee;

	@Column(name = "FEE_CONSESSION", columnDefinition = "NUMBER(6) DEFAULT 0", nullable = false)
	private UserType feeConsession;

	@Enumerated(EnumType.STRING)
	@Column(name = "COURSE_TYPE", columnDefinition = "VARCHAR(10) DEFAULT 'CLASSROOM'", nullable = false)
	private String courseType;

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

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Date getFeePaid() {
		return feePaid;
	}

	public void setFeePaid(Date feePaid) {
		this.feePaid = feePaid;
	}

	public Gender getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Gender courseFee) {
		this.courseFee = courseFee;
	}

	public UserType getFeeConsession() {
		return feeConsession;
	}

	public void setFeeConsession(UserType feeConsession) {
		this.feeConsession = feeConsession;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
}
