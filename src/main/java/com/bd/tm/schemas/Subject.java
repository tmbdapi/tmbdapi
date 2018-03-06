package com.bd.tm.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@Table(name = "subjects")
@EqualsAndHashCode(callSuper = true)
public class Subject extends BaseEntity {

	private static final long serialVersionUID = 8900706599699288148L;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "short_name")
	private String shortName;
	
	@OneToOne(mappedBy="currentInstitution")
	private Teacher teacher;
}
