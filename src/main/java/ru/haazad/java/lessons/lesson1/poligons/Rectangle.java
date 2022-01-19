package ru.haazad.java.lessons.lesson1.poligons;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle implements Polygon{

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public int calculatePerimeter() {
        return 2 * (width + height);
    }
}
