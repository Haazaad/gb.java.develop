package ru.haazad.java.lessons.lesson2;

import java.util.Iterator;

public interface ListRealisation<E> {

    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    int indexOf(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    void add(E value);

    E get(int index);

    boolean remove(E value);

    Iterator<E> iterator();

}
