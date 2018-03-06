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

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(name="email")
	private String email;

	@Column(name="gender", columnDefinition = "TINYINT")
	private Gender gender;

	@Column(name="role", columnDefinition = "TINYINT")
	private RoleType role;

	@Column(name="password")
	private String password;
}
