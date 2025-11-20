package com.Day12;
import java.util.NoSuchElementException;

// Node class
class ListNode {
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackDemo {

    private ListNode top;   // Points to the top element of the stack
    private int length;     // Tracks current size

    public StackDemo() {
        this.top = null;
        this.length = 0;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    // Push element onto stack
    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = top;  // New node points to old top
        top = newNode;       // Update top
        length++;
    }

    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        int result = top.data;
        top = top.next;  // Move top pointer down
        length--;
        return result;
    }

    // Peek top element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is Empty");
        }
        return top.data;
    }

    public static void main(String[] args) {
        StackDemo stack = new StackDemo();

        System.out.println("Size: " + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Size after pushes: " + stack.size());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Size after pop: " + stack.size());
        System.out.println("Peek: " + stack.peek());
        System.out.println("Final Size: " + stack.size());
    }
}
