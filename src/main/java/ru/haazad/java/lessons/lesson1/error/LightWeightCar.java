package ru.haazad.java.lessons.lesson1.error;

public class LightWeightCar extends Car implements Moveable{

    public LightWeightCar(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    void open() {
        System.out.println("Car is open");
    }

    @Override
    public void move() {
        System.out.println("Car is moving");
    }

}
