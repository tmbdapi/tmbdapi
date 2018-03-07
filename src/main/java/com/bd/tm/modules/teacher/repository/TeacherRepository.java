package com.bd.tm.modules.teacher.repository;

import com.bd.tm.schemas.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TeacherRepository
        extends JpaRepository<Teacher, Integer>, JpaSpecificationExecutor<Teacher> {
}

