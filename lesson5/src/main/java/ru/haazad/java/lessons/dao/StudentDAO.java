package ru.haazad.java.lessons.dao;

import ru.haazad.java.lessons.entities.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();

    Student findById(Long id);

    default Student add(Student student) {
        return update(student);
    }

    Student update(Student student);

    void delete(Student student);

    default void deleteById(Long id) {
        Student student = findById(id);
        delete(student);
    }
}
