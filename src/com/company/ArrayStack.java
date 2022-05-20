package com.company;

public class ArrayStack<T> implements StackInterface<T> {

    private int size = 16;
    private T[] array;
    private int topIndex;

    public ArrayStack(int size) {
        this.size = size;
        array = (T[]) new Object[this.size];
        topIndex = 0;
    }

    public ArrayStack() {
        array = (T[]) new Object[size];
        topIndex = 0;
    }
    @Override
    public boolean isEmpty() {
        return topIndex == 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public T pop() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        T temp = array[--topIndex];
        if(Math.floorDiv(size, 4) >= topIndex) {
            decreaseStackSize();
        }
        return temp;
    }

    @Override
    public void push(T elem) throws FullStackException {
        if(isFull()) throw new FullStackException();
        array[topIndex++] = elem;
        if(Math.floorDiv(size, 4)*3 <= topIndex) {
            increaseStackSize();
        }
    }

    @Override
    public T top() throws EmptyStackException {
        if(isEmpty()) throw new EmptyStackException();
        return array[topIndex-1];
    }

    @Override
    public int size() {
        return topIndex;
    }

    private void increaseStackSize() {
        size *= 2;
        T[] newArray = (T[]) new Object[size];
        for(int i = 0; i< topIndex; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void decreaseStackSize() {
        if (!(size <= 1)) {
            size = Math.floorDiv(size, 2);
            T[] newArray = (T[]) new Object[size];
            for (int i = 0; i < topIndex; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public int capacity() { return size; }
}
