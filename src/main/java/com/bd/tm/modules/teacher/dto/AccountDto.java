package com.bd.tm.modules.teacher.dto;

import com.bd.tm.enums.Gender;
import com.bd.tm.enums.RoleType;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class AccountDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;

    @NotNull
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @NotNull
    @Size(max = 45)
    private String phoneNumber;

    @NotNull
    @Size(max = 45)
    private String email;

    @NotNull
    private Gender gender;

    @NotNull
    private RoleType role;

    @NotNull
    @Size(max = 100)
    private String password;
}
