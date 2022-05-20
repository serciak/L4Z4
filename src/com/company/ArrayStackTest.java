package com.company;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    ArrayStack<Integer> arrayStack;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        arrayStack = new ArrayStack<>(4);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() throws FullStackException {
        assertTrue(arrayStack.isEmpty());
        arrayStack.push(11);
        assertFalse(arrayStack.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void pop() throws FullStackException, EmptyStackException {
        assertThrows(EmptyStackException.class, () -> {
            arrayStack.pop();
        });
        arrayStack.push(11);
        assertEquals(11, arrayStack.pop());
        assertEquals(2, arrayStack.capacity());
        arrayStack.push(11);
        arrayStack.push(12);
        arrayStack.push(13);
        assertEquals(8, arrayStack.capacity());
        assertEquals(13, arrayStack.pop());
        assertEquals(4, arrayStack.capacity());
    }

    @org.junit.jupiter.api.Test
    void push() throws FullStackException, EmptyStackException {
        arrayStack.push(11);
        assertEquals(11, arrayStack.pop());
        assertEquals(2, arrayStack.capacity());
        arrayStack.push(11);
        assertEquals(4, arrayStack.capacity());
        arrayStack.push(11);
        arrayStack.push(11);
        assertEquals(8, arrayStack.capacity());
    }

    @org.junit.jupiter.api.Test
    void top() throws FullStackException, EmptyStackException {
        assertThrows(EmptyStackException.class, () -> {
            arrayStack.top();
        });
        arrayStack.push(11);
        arrayStack.push(12);
        assertEquals(12, arrayStack.top());
    }

    @org.junit.jupiter.api.Test
    void size() throws FullStackException {
        assertEquals(0, arrayStack.size());
        arrayStack.push(11);
        arrayStack.push(11);
        assertEquals(2, arrayStack.size());
    }
}