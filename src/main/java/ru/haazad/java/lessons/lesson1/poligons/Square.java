package ru.haazad.java.lessons.lesson1.poligons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Square implements Polygon{

    private int width;

    public Square(int width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return width * width;
    }

    @Override
    public int calculatePerimeter() {
        return 4 * width;
    }
}
