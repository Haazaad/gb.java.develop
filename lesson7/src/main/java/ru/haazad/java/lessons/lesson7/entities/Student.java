package ru.haazad.java.lessons.lesson7.entities;

import lombok.Data;
import ru.haazad.java.lessons.lesson7.dtos.StudentDto;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    public Student() {
    }

    public Student(StudentDto studentDto) {
        this.id = studentDto.getId();
        this.name = studentDto.getName();
        this.age = studentDto.getAge();
    }
}
