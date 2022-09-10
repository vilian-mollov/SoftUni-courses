package Generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static<T> T[] create(int length, T items) {
        T[] array = (T[])Array.newInstance(items.getClass(),length);
        Arrays.fill(array, items);
        return array;
    }

    @SuppressWarnings("unchecked")
    public static<T> T[] create(Class<T> clazz, int length, T items){
        T[] array = (T[])Array.newInstance(clazz,length);
        Arrays.fill(array,items);
        return array;
    }

}
