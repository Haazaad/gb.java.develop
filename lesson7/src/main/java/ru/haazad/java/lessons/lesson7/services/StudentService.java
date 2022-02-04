package ru.haazad.java.lessons.lesson7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.haazad.java.lessons.lesson7.entities.Student;
import ru.haazad.java.lessons.lesson7.repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.getStudentById(id);
    }

    public Student save(Student student) {
        studentRepository.save(student);
        return student;
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
