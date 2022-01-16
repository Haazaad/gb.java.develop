package ru.haazad.java.lessons.lesson2;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListRealisationImpl<E> implements ListRealisation<E> {
    private int size;
    private E[] data;

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i])){
                return i;
            }
        }
        return -1;
    }

   @Override
    public void add(E value) {
        checkAndInflate();
        data[size++] = value;
    }

    private void checkAndInflate() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateNewLength());
        }
    }

    private int calculateNewLength() {
        return size == 0 ? 1 : size * 2;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Incorrect input index %d, min index is %d, max index is %d", index, 0, size - 1));
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    private E remove(int index) {
        checkIndex(index);
        E removedValue = data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedValue;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListRealisationImplIterator<>();
    }

    class ArrayListRealisationImplIterator<E> implements Iterator<E>{
        int index;
        E current;

        public ArrayListRealisationImplIterator() {
            this.index = 0;
            if (hasNext()) {
                this.current = (E) ArrayListRealisationImpl.this.data[index];
            }
        }

        @Override
        public boolean hasNext() {
            return index != ArrayListRealisationImpl.this.size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                index++;
                current = (E) ArrayListRealisationImpl.this.data[index];
                return current;
            }
            return null;
        }

        @Override
        public void remove() {
            ArrayListRealisationImpl.this.remove(index);
        }
    }
}
