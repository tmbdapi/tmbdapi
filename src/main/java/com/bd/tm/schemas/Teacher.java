package com.bd.tm.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bd.tm.enums.Medium;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "teachers")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

	private static final long serialVersionUID = 4243691078357640829L;
	
	@Column(name="subject_of_interest")
	private String subjectOfInterest;
	
	@Column(name="interested_medium", columnDefinition = "TINYINT")
	private Medium interestedMedium;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="status", columnDefinition = "TINYINT")
	private Integer status;
	
	@Column(name="introduction")
	private String introduction;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Account account;
	
	@JoinColumn(name="current_institution")
	@OneToOne(fetch=FetchType.LAZY)
	private Institution currentInstitution;
	
	@JoinColumn(name="subject_of_study")
	@OneToOne(fetch=FetchType.LAZY)
	private Subject subjectOfStudy;
}
