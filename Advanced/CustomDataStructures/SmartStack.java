package Workshop;

import java.util.ArrayDeque;
import java.util.function.Consumer;

public class SmartStack {

    private static class Node {
        private int element;
        private Node prev;

        public Node(int element, Node prev) {
            this.element = element;
            this.prev = prev;
        }

    }

    private Node top;
    private int size;

    public SmartStack() {
    }


    public void push(int element) {
        Node newNode = new Node(element, this.top);
        this.top = newNode;
        this.size++;
    }


    public int pop() {
        ensureNotEmpty();
        int element = this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    public int peak() {
        return this.top.element;
    }

    public void forEach(Consumer<Integer> consumer) {
        ensureNotEmpty();

        Node current = this.top;

        while (current != null) {
            consumer.accept(current.element);
            current = current.prev;
        }

    }

    public int size() {
        return this.size;
    }

    public void ensureNotEmpty() {
        if (this.top == null) {
            throw new IllegalArgumentException("Cannot execute on empty stack!");
        }
    }

}
