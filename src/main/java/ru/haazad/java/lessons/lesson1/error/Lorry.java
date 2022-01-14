package ru.haazad.java.lessons.lesson1.error;

public class Lorry extends Car implements Stopable, Moveable {

    public Lorry(Engine engine, String color, String name) {
        super(engine, color, name);
    }

    @Override
    public void move(){
        System.out.println("Car is moving");
    }

    @Override
    public void stop(){
        System.out.println("Car is stop");
    }

    @Override
    void open() {

    }
}
