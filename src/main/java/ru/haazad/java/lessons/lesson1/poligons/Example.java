package ru.haazad.java.lessons.lesson1.poligons;

import java.util.ArrayList;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        List<Polygon> polygons = new ArrayList<>();
        polygons.add(new Rectangle(4, 3));
        polygons.add(new Square(5));
        polygons.add(new Triangle(2, 4, 1));
        for (Polygon p: polygons) {
            System.out.println("Area of " + p.getClass().getSimpleName() + " is: " + p.calculateArea());
            System.out.println("Perimeter of " + p.getClass().getSimpleName() + " is: " + p.calculatePerimeter());
        }
    }
}
