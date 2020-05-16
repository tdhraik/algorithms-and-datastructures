package main.java.fastslowpointers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
 */
class LinkedListHasCycle {

    private boolean hasCycle( Number root ) {
        Number slow = root;
        Number fast = root.next;
        boolean hasCycle = false;
        while( fast != null && fast.next !=null ) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                hasCycle = true;
            }
        }
        return hasCycle;
    }

    @Test
    void shouldHaveCycle() {
        //setup
        Number root = new Number(1);
        root.next = new Number(2);
        root.next.next = new Number(3);
        root.next.next.next = new Number(4);
        root.next.next.next.next = new Number(5);
        root.next.next.next.next.next = new Number(6);
        root.next.next.next.next.next.next = root.next;

        // assertions
        assertTrue(hasCycle(root));

        root.next.next.next.next.next.next = null;
        assertFalse(hasCycle(root));
    }


    class Number {
        private int value;
        private Number next;

        public Number() {}

        public Number(int value) {
            this.value = value;
        }

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
    }
}
