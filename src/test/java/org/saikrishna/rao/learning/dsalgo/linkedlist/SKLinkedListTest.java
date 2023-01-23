package org.saikrishna.rao.learning.dsalgo.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SKLinkedListTest {


    @Test
    public void testAddItem() {
        SKLinkedList<Integer> skLinkedList = new SKLinkedList<>();
        skLinkedList.push(10);
        skLinkedList.push(20);
        skLinkedList.push(30);
        skLinkedList.push(40);
        assertThat(skLinkedList.count()).isEqualTo(4);
    }

    @Test
    void testGetLast() {
        SKLinkedList<Integer> skLinkedList = new SKLinkedList<>();
        skLinkedList.push(10);
        skLinkedList.push(20);
        assertThat(skLinkedList.tailNode().get().getData()).isEqualTo(20);
    }

    @Test
    void testNewHead() {
        SKLinkedList<Integer> skLinkedList = new SKLinkedList<>();
        skLinkedList.push(10);
        skLinkedList.newHead(20);
        assertThat(skLinkedList.getHead().getData()).isEqualTo(20);
    }

    @Test
    void testPop() {
        SKLinkedList<Integer> skLinkedList = new SKLinkedList<>();
        skLinkedList.push(10);
        skLinkedList.push(20);
        skLinkedList.push(30);
        assertThat(skLinkedList.pop().getData()).isEqualTo(10);
        assertThat(skLinkedList.getHead().getData()).isNotNull().isEqualTo(20);
        assertThat(skLinkedList.count()).isEqualTo(2);
    }

    @Test
    void testPopNull() {
        SKLinkedList<Integer> skLinkedList = new SKLinkedList<>();
        assertThat(skLinkedList.pop()).isNull();
    }

}