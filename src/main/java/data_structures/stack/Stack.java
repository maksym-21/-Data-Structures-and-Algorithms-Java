package data_structures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack implements Iterable<Integer> {
    private final int capacity;
    private int top;
    private final int[] stack;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = new int[capacity];
    }

    public void push(int number)  {
        if (size() == capacity) throw new RuntimeException("Stack is full!");
        stack[++top] = number;
    }

    public int pop() {
        if (top == -1) throw new NoSuchElementException("Stack is empty!");

        int output = stack[top];

        stack[top] = -1;
        top -= 1;

        return output;
    }

    public int peek() {
        if (top == -1) throw new NoSuchElementException("Stack is empty!");

        return stack[top];
    }

    public int size() {
        return top + 1;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            private int currentPosition = 0;

            @Override
            public boolean hasNext() {
                return currentPosition < size();
            }

            @Override
            public Integer next() {
                if (currentPosition + 1 < capacity) {
                    int tmp = stack[currentPosition++];

                    return tmp >= 1 ? tmp : null;
                }
                else throw new NoSuchElementException();
            }
        };
    }
}
