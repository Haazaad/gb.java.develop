package ru.haazad.java.lessons.lesson2;

import java.util.Arrays;
import java.util.Iterator;

public class LinkedListRealisationImpl<E> implements ListRealisation<E> {
    private int size;
    private Node<E>[] data;
    private Node<E> firstNode;
    private Node<E> lastNode;

    public LinkedListRealisationImpl() {
        this.size = 0;
        this.data = new Node[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (value.equals(data[i].value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void add(E value) {
        Node<E> lastNodeInArray = data[size - 1];
        if (lastNodeInArray.prevNode == null) {
            addFirst(value);
        } else if (lastNodeInArray.nextNode == null) {
            addLast(value);
        } else {
            checkAndInflate();
            int indexOfLastNodeInArray = indexOf(lastNodeInArray.value);
            int indexOfNextNodeAfterLastInArray = indexOf(lastNodeInArray.nextNode.value);
            Node<E> newNode = new Node<>(value, data[indexOfNextNodeAfterLastInArray], data[indexOfLastNodeInArray]);
            data[indexOfLastNodeInArray].nextNode = newNode;
            data[indexOfNextNodeAfterLastInArray].prevNode = newNode;
            data[size++] = newNode;
        }
    }

    public void addFirst(E value) {
        checkAndInflate();
        Node<E> newNode = new Node<>(value, firstNode, null);
        firstNode.prevNode = newNode;
        data[size++] = newNode;
        firstNode = newNode;
    }

    public void addLast(E value) {
        checkAndInflate();
        Node<E> newNode = new Node<>(value, null, lastNode);
        lastNode.nextNode = newNode;
        data[size++] = newNode;
        lastNode = newNode;
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
        return data[index].value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Incorrect input index %d, min index is %d, max index is %d", index, 0, size - 1));
        }
    }

    public E getFirst() {
        return getValue(firstNode);
    }

    public E getLast() {
        return getValue(lastNode);
    }

    private E getValue(Node<E> node) {
        return node != null ? node.value : null;
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return index != -1 && remove(index) != null;
    }

    private E remove(int index) {
        checkIndex(index);
        Node<E> removedNode = data[index];
        if (removedNode.prevNode == null) {
            int indexOfNextNode = indexOf(removedNode.nextNode.value);
            firstNode = data[indexOfNextNode];
            data[indexOfNextNode].prevNode = null;
        } else if (removedNode.nextNode == null) {
            int indexOfPrevNode = indexOf(removedNode.prevNode.value);
            lastNode = data[indexOfPrevNode];
            data[indexOfPrevNode].nextNode = null;
        } else {
            int indexOfNextNode = indexOf(removedNode.nextNode.value);
            int indexOfPrevNode = indexOf(removedNode.prevNode.value);
            data[indexOfNextNode].prevNode = data[indexOfPrevNode];
            data[indexOfPrevNode].nextNode = data[indexOfNextNode];
        }
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return removedNode.value;
    }

    public boolean removeFirst(E value) {
        return remove(value);
    }

    public boolean removeLast(E value) {
        return remove(value);
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListRealisationImplIterator<>();
    }

    class Node<E> {
        E value;
        Node<E> prevNode;
        Node<E> nextNode;

        public Node(E value) {
            this.value = value;
        }

        public Node(E value, Node<E> next) {
            this(value);
            this.nextNode = next;
        }

        public Node(E value, Node<E> next, Node<E> prev) {
            this(value, next);
            this.prevNode = prev;
        }
    }

    class LinkedListRealisationImplIterator<E> implements Iterator<E> {
        int index;
        Node<E> current;

        public LinkedListRealisationImplIterator() {
            this.index = 0;
            if (hasNext()) {
                this.current = (Node<E>) LinkedListRealisationImpl.this.firstNode;
            }
        }

        @Override
        public boolean hasNext() {
            return index != LinkedListRealisationImpl.this.size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                E value = current.value;
                index++;
                current = current.nextNode;
                return value;
            }
            return null;
        }

        @Override
        public void remove() {
            LinkedListRealisationImpl.this.remove(index);
        }
    }
}
