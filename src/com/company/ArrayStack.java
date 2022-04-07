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
        if(Math.floorDiv(size, 4) >= topIndex) {
            decreaseStackSize();
        }
        return array[topIndex--];
    }

    @Override
    public void push(T elem) throws FullStackException {
        if(isFull()) throw new FullStackException();
        if(Math.floorDiv(size, 4)*3 <= topIndex) {
            increaseStackSize();
        }
        array[topIndex++] = elem;
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
        for(int i = 0; i< topIndex-1; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void decreaseStackSize() {
        size = Math.floorDiv(size, 2);
        T[] newArray = (T[]) new Object[size];
        for(int i = 0; i < topIndex-1; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
