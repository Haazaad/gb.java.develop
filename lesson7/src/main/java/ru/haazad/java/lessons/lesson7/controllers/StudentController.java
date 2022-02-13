package ru.haazad.java.lessons.lesson7.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.haazad.java.lessons.lesson7.dtos.StudentDto;
import ru.haazad.java.lessons.lesson7.entities.Student;
import ru.haazad.java.lessons.lesson7.services.StudentService;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAll().stream().map(StudentDto::new).collect(Collectors.toList());
    }

    @PostMapping
    public void createNewStudent(@RequestBody StudentDto studentDto) {
        studentService.save(new Student(studentDto));
    }

    @GetMapping("/{id}")
    public StudentDto getStudentById(@PathVariable Long id) {
        return new StudentDto(studentService.getStudentById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Student with id %d not found", id))));
    }

    @PutMapping("/{id}")
    public StudentDto updateStudentById(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        Student student = studentService.getStudentById(id).orElseThrow(() -> new EntityNotFoundException(String.format("Student with id %d not found", id)));
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        return new StudentDto(studentService.save(student));
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }
}
