package com.bd.tm.schemas;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "institutions")
@EqualsAndHashCode(callSuper = true)
public class Institution extends BaseEntity {

	private static final long serialVersionUID = -7297213157674416649L;
	
	@Column
	private String fullName;

	@Column
	private String shortName;
}
