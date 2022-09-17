package IteratorsAndComparators.lab;

import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }


//    private final class LibIterator implements Iterator<Book> {
//        private int index = 0;
//
//        @Override
//        public boolean hasNext() {
//            if (this.index < books.length) {
//                return true;
//            }
//            return false;
//        }
//
//        @Override
//        public Book next() {
//            return books[index++];
//        }
//    }


    @Override
    public Iterator<Book> iterator() {
        // Orr just return new LibIterator();
        // hacky - return Arrays.stream(books).iterator();
        return new Iterator<Book>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < books.length;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };

    }
}
