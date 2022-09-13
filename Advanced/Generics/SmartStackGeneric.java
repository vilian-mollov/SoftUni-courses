package Generics;

import java.util.function.Consumer;

public class SmartStackGeneric<T> {

    private static class Node<E> {
        private E element;
        private Node<E> prev;

        public Node(E element, Node prev) {
            this.element = element;
            this.prev = prev;
        }

    }

    private Node top;
    private int size;

    public SmartStackGeneric() {
    }


    public void push(T element) {
        Node<T> newNode = new Node<>(element, this.top);
        this.top = newNode;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        ensureNotEmpty();
        T element = (T) this.top.element;
        this.top = this.top.prev;
        this.size--;
        return element;
    }

    @SuppressWarnings("unchecked")
    public T peak() {
        return (T) this.top.element;
    }

    public void forEach(Consumer<T> consumer) {
        ensureNotEmpty();

        Node<T> current = this.top;

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
