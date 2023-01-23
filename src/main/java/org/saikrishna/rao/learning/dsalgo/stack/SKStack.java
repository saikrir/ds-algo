package org.saikrishna.rao.learning.dsalgo.stack;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

public class SKStack<T> {

    private final int MAX_SIZE;
    private Optional<Node<T>> head = Optional.empty();
    @Getter
    private int size = 0;

    public SKStack(int maxSize) {
        MAX_SIZE = maxSize;
    }

    public void push(T data) {

        if (isFull()) {
            throw new RuntimeException("Stack Overflow exception");
        }

        Optional<Node<T>> oldHead = this.head;
        this.head = Optional.of(new Node<>(data));

        if (!oldHead.isEmpty()) {
            this.head.get().setNextNode(oldHead);
        }

        this.size = this.size + 1;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow exception");
        }

        Node<T> currentHead = this.head.get();
        this.head = currentHead.getNextNode();
        this.size = this.size - 1;
        return currentHead.getData();
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow exception");
        }

        return this.head.get().getData();
    }

    public boolean isFull() {
        return this.size == this.MAX_SIZE;
    }

    public boolean isEmpty() {
        return this.head.isEmpty();
    }

    @Data
    @RequiredArgsConstructor
    protected class Node<T> {
        private final T data;
        private Optional<Node<T>> nextNode;
    }

}
