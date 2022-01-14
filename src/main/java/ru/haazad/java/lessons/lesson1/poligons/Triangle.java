package ru.haazad.java.lessons.lesson1.poligons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Triangle implements Polygon{
    private int a;
    private int b;
    private int c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calculateArea() {
        double halfPerimeter = (double) calculatePerimeter() / 2;
        return Math.sqrt(Math.abs(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
    }

    @Override
    public int calculatePerimeter() {
        return a + b + c;
    }
}
