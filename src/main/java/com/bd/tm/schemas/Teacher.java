package com.bd.tm.schemas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher implements Serializable {

	private static final long serialVersionUID = 4243691078357640829L;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="account_id")
	@OneToOne(fetch=FetchType.LAZY)
	private Account account;
	
	@Column(name="current_institution")
	@OneToOne(fetch=FetchType.LAZY)
	private Institution institution;
	
	@Column(name="subject_of_study")
	@OneToOne(fetch=FetchType.LAZY)
	private Subject subjectOfStudy;
	
	@Column(name="subject_of_interest")
	private String subjectOfInterest;
	
	@Column(name="interested_medium")
	private Integer interestedMedium;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="introduction")
	private String introduction;
}
