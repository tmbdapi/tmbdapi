package com.bd.tm.modules.teacher.controller;

import com.bd.tm.lib.Utils;
import com.bd.tm.modules.teacher.dto.TeacherDto;
import com.bd.tm.modules.teacher.service.TeacherService;
import com.bd.tm.schemas.Teacher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class TeacherProfileController {

    private final TeacherService teacherService;

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto getTeacher(@PathVariable("id") Integer id) {
        return Utils.convert(teacherService.get(id), TeacherDto.class);
    }

    @RequestMapping(value = "/teachers", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto createTeacher(@RequestBody @Valid TeacherDto teacherDto) {
        Teacher teacher = teacherService.create(teacherDto);

        return Utils.convert(teacher, TeacherDto.class);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TeacherDto updateTeacher(@PathVariable("id") Integer id, @RequestBody @Valid TeacherDto teacherDto) {
        Teacher teacher = teacherService.update(id, teacherDto);

        return Utils.convert(teacher, TeacherDto.class);
    }

    @RequestMapping(value = "/teachers/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable("id") Integer id) {
        teacherService.delete(id);
    }
}
