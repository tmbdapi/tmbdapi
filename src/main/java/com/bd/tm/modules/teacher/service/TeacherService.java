package com.bd.tm.modules.teacher.service;

import com.bd.tm.lib.Utils;
import com.bd.tm.modules.teacher.dto.TeacherDto;
import com.bd.tm.modules.teacher.repository.AccountRepository;
import com.bd.tm.modules.teacher.repository.InstitutionRepository;
import com.bd.tm.modules.teacher.repository.SubjectRepository;
import com.bd.tm.modules.teacher.repository.TeacherRepository;
import com.bd.tm.schemas.Teacher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final AccountRepository accountRepository;
    private final InstitutionRepository institutionRepository;
    private final SubjectRepository subjectRepository;

    public Teacher get(Integer id) {
        return teacherRepository.findOne(id);
    }

    public Teacher create(TeacherDto teacherDto) {
        Teacher teacher = Utils.convert(teacherDto, Teacher.class);

        teacherRepository.saveAndFlush(teacher);

        return teacher;
    }

    public Teacher update(Integer id, TeacherDto teacherDto) {
        Teacher teacher = teacherRepository.getOne(id);
        Utils.merge(teacherDto, teacher);

        teacherRepository.saveAndFlush(teacher);

        return teacher;
    }

    //In real production we cant delete the data. We can change status instead. todo: have to refactor
    public Teacher delete(Integer id) {
        Teacher teacher = teacherRepository.getOne(id);

        teacherRepository.delete(teacher);

        return teacher;
    }
}
