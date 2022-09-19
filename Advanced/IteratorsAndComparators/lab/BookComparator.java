package IteratorsAndComparators.lab;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book f, Book s) {
        //ORR to escape code duplication -> just : return f.compareTo(s); - method in the Book class
        int result = f.getTitle().compareTo(s.getTitle());

        if(result==0){
            result = Integer.compare(f.getYear(),s.getYear());
        }

        return result;
    }
}
