package com.bd.tm.modules.teacher.repository;

import com.bd.tm.schemas.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SubjectRepository
        extends JpaRepository<Subject, Integer>, JpaSpecificationExecutor<Subject> {
}