package myProject.coffee;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class MyStack<T> {

    private Deque<T> stack;

    public MyStack(final Deque<T> stack) {
        this.stack = stack;
    }

    public MyStack() {
        stack = new LinkedList<>();
    }

    public void push(T element) {
        stack.addLast(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty. You can't use pop()");
        }
        return stack.removeLast();
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty. You can't use peek()");
        }
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
