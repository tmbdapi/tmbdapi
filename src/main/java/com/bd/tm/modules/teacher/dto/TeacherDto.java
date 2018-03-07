package com.bd.tm.modules.teacher.dto;

import com.bd.tm.enums.Medium;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class TeacherDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;

    @NotNull
    private AccountDto account;

    @NotNull
    private InstitutionDto currentInstitution;

    @NotNull
    private SubjectDto subjectOfStudy;

    @NotNull
    @Size(max = 250)
    private String subjectOfInterest;

    @NotNull
    private Medium interestedMedium;

    @NotNull
    private Integer age;

    @NotNull
    private Integer status;

    @Size(max = 250)
    private String introduction;
}
