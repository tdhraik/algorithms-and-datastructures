package main.java.fastslowpointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 *
 * Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished.
 * The algorithm should have O(N) time complexity where ‘N’ is the number of nodes in the LinkedList.
 *
 */
class LinkedListPalindrome {

    private boolean isPalindrome(Number root) {
        boolean isPalindrome = true;
        Number ptr1 = root;
        Number ptr2 = root;
        int sizeOfList = 1;
        while(ptr2.next != null && ptr2.next.next != null) {
            sizeOfList = sizeOfList + 2;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        if(ptr2.next != null) {
            ptr2 = ptr2.next;
            sizeOfList++;
        }
        ptr2 = root;
        for (int i = 0; i < sizeOfList/2; i++) {
            if(ptr1.value != ptr2.value){
                isPalindrome = false;
            }
        }
        if( (sizeOfList%2) != 0){
//            ptr1.next.value == ptr2
        }

        return true;
    }

    @Test
    void shouldBePalindrome() {
        Number root = new Number(2);
        root.next = new Number(4);
        root.next.next = new Number(6);
        root.next.next.next = new Number(4);
        root.next.next.next.next = new Number(2);
        assertTrue(isPalindrome(root));
    }

    class Number {
        private int value;
        private Number next;

        public Number() {
        }

        public Number(int value) {
            this.value = value;
        }

        public Number(int value, Number next) {
            this.value = value;
            this.next = next;
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
