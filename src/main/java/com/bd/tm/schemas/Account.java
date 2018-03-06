package com.bd.tm.schemas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "accounts")
public class Account implements Serializable {

	private static final long serialVersionUID = -8367681116861742571L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "first_name")
	private String firstname;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "phone_number", unique = true)
	private String phoneNumber;

	@Column(name="email")
	private String email;

	@Column(name="gender")
	private Integer gender;

	@Column(name="role")
	private Integer role;

	@Column(name="password")
	private String password;
}
