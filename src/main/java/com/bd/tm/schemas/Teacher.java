package com.bd.tm.schemas;

import com.bd.tm.enums.Medium;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@Table(name = "teachers")
@EqualsAndHashCode(callSuper = true)
public class Teacher extends BaseEntity {

    private static final long serialVersionUID = 4243691078357640829L;

    @Column
    private String subjectOfInterest;

    @Column(columnDefinition = "TINYINT")
    private Medium interestedMedium;

    @Column(name = "age")
    private Integer age;

    @Column(columnDefinition = "TINYINT")
    private Integer status;

    @Column
    private String introduction;

    @JoinColumn
    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @JoinColumn(name = "current_institution")
    @OneToOne(cascade = CascadeType.ALL)
    private Institution currentInstitution;

    @JoinColumn(name = "subject_of_study")
    @OneToOne(cascade = CascadeType.ALL)
    private Subject subjectOfStudy;
}
