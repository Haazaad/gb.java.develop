package ru.haazad.java.lessons;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.haazad.java.lessons.config.Factory;
import ru.haazad.java.lessons.dao.StudentDAO;
import ru.haazad.java.lessons.entities.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainApp {
    private static Scanner scanner;
    private static StudentDAO studentDAO;

    public static void main(String[] args) {
        init();
        scanner = new Scanner(System.in);
        printCmd();
        int cmd = Integer.parseInt(scanner.nextLine());
        boolean r = false;
        while (!r) {
            switch (cmd) {
                case 0:
                    r = true;
                    break;
                case 1:
                    List<Student> students = studentDAO.findAll();
                    for (Student s: students) {
                        System.out.println(s);
                    };
                    break;
                case 2:
                    System.out.print("Input id: ");
                    long id = Long.parseLong(scanner.next());
                    System.out.println(studentDAO.findById(id));
                    break;
                case 3:
                    System.out.print("Input name: ");
                    String name = scanner.next();
                    System.out.print("Input mark: ");
                    int mark = Integer.parseInt(scanner.next());
                    Student student = new Student(name, mark);
                    studentDAO.add(student);
                    break;
                case 4:
                    System.out.print("Input id: ");
                    long id1 = Long.parseLong(scanner.next());
                    System.out.print("Input name: ");
                    String name1 = scanner.next();
                    System.out.print("Input mark: ");
                    int mark1 = Integer.parseInt(scanner.next());
                    Student student1 = studentDAO.findById(id1);
                    student1.setName(name1);
                    student1.setMark(mark1);
                    studentDAO.update(student1);
                    break;
                case 5:
                    System.out.print("Input id: ");
                    long id2 = Long.parseLong(scanner.next());
                    studentDAO.deleteById(id2);
                    break;
            }
        }
    }

    private static void init() {
        studentDAO = Factory.getStudentDAO();
        try (SessionFactory sessionFactory = Factory.getSessionFactory()){
            Session session = sessionFactory.getCurrentSession();
            String sql = Files.lines(Paths.get("init.sql")).collect(Collectors.joining(" "));
            session.beginTransaction();
            session.createNativeQuery(sql).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printCmd() {
        System.out.println("1 - select all\n" +
                "2 - select by id\n" +
                "3 - add new\n" +
                "4 - update by id\n" +
                "5 - delete by id\n" +
                "0 - exit");
    }
}
