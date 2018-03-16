package com.bd.tm.modules.teacher.repository;

import com.bd.tm.schemas.Institution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface InstitutionRepository
        extends JpaRepository<Institution, Integer>, JpaSpecificationExecutor<Institution> {
}