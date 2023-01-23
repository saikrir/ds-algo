package org.saikrishna.rao.learning.dsalgo.stack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SKStackTest {

    @Test
    void push() {
        SKStack<Integer> skStack = new SKStack<>(2);
        assertThat(skStack.isEmpty()).isEqualTo(true);
        skStack.push(100);
        skStack.push(101);
        assertThat(skStack.isEmpty()).isEqualTo(false);
        assertThat(skStack.isFull()).isEqualTo(true);
    }

    @Test
    void pushOverFlow() {
        SKStack<Integer> skStack = new SKStack<>(2);
        assertThat(skStack.isEmpty()).isEqualTo(true);
        skStack.push(100);
        skStack.push(101);
        assertThrows(RuntimeException.class, () -> skStack.push(102));
    }

    @Test
    void pop() {
        SKStack<Integer> skStack = new SKStack<>(2);
        assertThat(skStack.isEmpty()).isEqualTo(true);
        skStack.push(100);
        skStack.push(101);
        assertThat(skStack.pop()).isEqualTo(101);
        assertThat(skStack. getSize()).isEqualTo(1);
        skStack.push(103);
        assertThat(skStack. getSize()).isEqualTo(2);
        assertThat(skStack.peek()).isEqualTo(103);
    }

    @Test
    void popUndeflow() {
        SKStack<Integer> skStack = new SKStack<>(2);
        assertThrows(RuntimeException.class, ()-> skStack.pop());
    }

    @Test
    void peek() {
        SKStack<Integer> skStack = new SKStack<>(2);
        assertThat(skStack.isEmpty()).isEqualTo(true);
        skStack.push(100);
        skStack.push(101);
        assertThat(skStack.peek()).isEqualTo(101);
        assertThat(skStack.getSize()).isEqualTo(2);
    }
}