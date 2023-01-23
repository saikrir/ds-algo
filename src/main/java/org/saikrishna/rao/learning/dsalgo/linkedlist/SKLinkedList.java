package org.saikrishna.rao.learning.dsalgo.linkedlist;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

public class SKLinkedList<T extends Comparable<T>> {

    private Optional<Node<T>> headNode;

    private Integer count;

    public SKLinkedList() {
        headNode = Optional.empty();
        count = 0;
    }

    public void push(T data) {
        if (headNode.isEmpty()) {
            headNode = Optional.of(new Node<>(data));
        } else {
            Node<T> tailNode = tailNode().get();
            tailNode.setNextNode(Optional.of(new Node<>(data)));
        }
        count = count + 1;
    }

    public T newHead(T data) {
        Optional<Node<T>> old = this.headNode;
        Node<T> newHead = new Node<>(data);
        newHead.setNextNode(old);
        this.headNode = Optional.of(newHead);
        return this.headNode.get().getData();
    }

    public Node<T> getHead() {
        return this.headNode.isPresent() ? this.headNode.get() : null;
    }

    public Node<T> pop() {
        if (this.headNode.isEmpty()) return null;

        Node<T> headModeUW = this.headNode.get();

        this.headNode = headModeUW.getNextNode();
        this.count = this.count - 1;
        return headModeUW;
    }

    public Optional<Node<T>> previousNodeTo(Node<T> aNode) {
        Node<T> node;

        for (node = this.headNode.get(); node.getNextNode().isPresent() && node.getNextNode().equals(aNode); node = node.getNextNode().get()) {
        }

        return Optional.ofNullable(node);
    }


    public Integer count() {
        return count;
    }

    protected Optional<Node<T>> tailNode() {
        if (this.headNode.isEmpty()) {
            return this.headNode;
        }

        Node<T> node;

        for (node = this.headNode.get(); node.getNextNode().isPresent(); node = node.getNextNode().get()) {
        }

        return Optional.of(node);
    }


    @Data
    @RequiredArgsConstructor
    public static class Node<T> {
        private final T data;
        private Optional<Node<T>> nextNode = Optional.empty();

    }
}
