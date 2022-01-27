package ru.haazad.java.lessons.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.haazad.java.lessons.config.Factory;
import ru.haazad.java.lessons.dao.StudentDAO;
import ru.haazad.java.lessons.entities.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private SessionFactory sessionFactory;

    public StudentDAOImpl() {
        this.sessionFactory = Factory.getSessionFactory();
    }

    @Override
    public List<Student> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Student> students = (List<Student>) session.createQuery("from Student", List.class);
            session.getTransaction().commit();
            return students;
        }
    }

    @Override
    public Student findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Student student = session.get(Student.class, id);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public Student update(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(student);
            session.getTransaction().commit();
            return student;
        }
    }

    @Override
    public void delete(Student student) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
    }
}
