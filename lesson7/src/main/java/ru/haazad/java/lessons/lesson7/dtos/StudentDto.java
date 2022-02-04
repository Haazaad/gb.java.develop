package ru.haazad.java.lessons.lesson7.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.haazad.java.lessons.lesson7.entities.Student;

@Getter
@Setter
@AllArgsConstructor
public class StudentDto {

    private Long id;

    private String name;

    private int age;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }
}
