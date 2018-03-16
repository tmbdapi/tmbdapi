package com.bd.tm.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "subjects")
@EqualsAndHashCode(callSuper = true)
public class Subject extends BaseEntity {

	private static final long serialVersionUID = 8900706599699288148L;

	@Column
	private String fullName;

	@Column
	private String shortName;

}
