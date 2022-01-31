package ru.haazad.java.lessons.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.haazad.java.lessons.dao.StudentDAO;
import ru.haazad.java.lessons.dao.impl.StudentDAOImpl;

public class Factory {
    public static SessionFactory getSessionFactory() {
        return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static StudentDAO getStudentDAO() {
        return new StudentDAOImpl();
    }
}
