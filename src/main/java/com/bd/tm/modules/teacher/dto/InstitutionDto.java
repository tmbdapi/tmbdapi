package com.bd.tm.modules.teacher.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class InstitutionDto implements Serializable {

    public static final long serialVersionUID = 1L;

    private int id;

    @NotNull
    @Size(max = 200)
    private String fullName;

    @Size(max = 10)
    private String shortName;
}

