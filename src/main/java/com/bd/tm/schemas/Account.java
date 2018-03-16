package com.bd.tm.schemas;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bd.tm.enums.Gender;
import com.bd.tm.enums.RoleType;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "accounts")
@EqualsAndHashCode(callSuper = true)
public class Account extends BaseEntity {

	private static final long serialVersionUID = -8367681116861742571L;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column(unique = true)
	private String phoneNumber;

	@Column
	private String email;

	@Column(columnDefinition = "TINYINT")
	private Gender gender;

	@Column(columnDefinition = "TINYINT")
	private RoleType role;

	@Column
	private String password;
}
