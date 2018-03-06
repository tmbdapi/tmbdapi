package com.bd.tm.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "institutions")
@EqualsAndHashCode(callSuper = true)
public class Institution extends BaseEntity {

	private static final long serialVersionUID = -7297213157674416649L;
	
	@Column(name = "full_name")
	private String fullName;

	@Column(name = "short_name")
	private String shortName;
	
	@OneToOne(mappedBy="subjectOfStudy")
	private Teacher teacher;
}
