package Generics;

import java.util.ArrayDeque;

public class Jar <E> {
    private final ArrayDeque<E> elements;

    public Jar() {
        this.elements = new ArrayDeque<>();
    }

    public void add(E element){
        this.elements.push(element);
    }

    public E remove(){
       return this.elements.pop();
    }

}
