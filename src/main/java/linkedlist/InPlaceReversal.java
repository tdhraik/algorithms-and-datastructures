package main.java.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given the head of a Singly LinkedList, reverse the LinkedList.
 * Write a function to return the new head of the reversed LinkedList.
 * O (N) and constant space
 */
class InPlaceReversal {

    private Number reverseList(Number root) {
        Number prev = null, current = root, temp = null;
        while(current!=null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    @Test
    void shouldReverseList() {
        Number root = new Number(2);
        root.next = new Number(4);
        root.next.next = new Number(6);
        root.next.next.next = new Number(8);
        root.next.next.next.next = new Number(10);

        assertEquals(10, reverseList(root).value);
    }

    class Number {
        private int value;
        private Number next;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Number getNext() {
            return next;
        }

        public void setNext(Number next) {
            this.next = next;
        }

        public Number() {
        }

        public Number(int value) {
            this.value = value;
        }

        public Number(int value, Number next) {
            this.value = value;
            this.next = next;
        }
    }
}
