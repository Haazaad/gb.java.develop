package ru.haazad.java.lessons.lesson1.error;

public class LightWeightCar extends Car implements Moveable{
    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}
