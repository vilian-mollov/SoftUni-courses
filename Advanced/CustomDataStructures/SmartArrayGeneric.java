package Generics;

public class SmartArrayGeneric <T> {

    private Object[] array;
    private int size;

    public SmartArrayGeneric() {
        array = new Object[4];
        size = 0;
    }

    public void add(T element) {
        if (this.size == this.array.length) {
            this.array = grow();
        }
        this.array[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, T element) {
        validate(index);
        int lastIndex = this.size - 1;
        T latsElement = (T)this.array[lastIndex];

        for (int i = lastIndex; i > index ; i--) {
            this.array[i] = this.array[i-1];
        }

        this.array[index] = element;

        add(latsElement);

    }



    @SuppressWarnings("unchecked")
    public T get(int index) {
        validate(index);
        return (T)this.array[index];
    }

    private void validate(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }


    public T remove(int index) {
        validate(index);
        size--;
        T element = get(index);


        for (int i = index; i < size ; i++) {
            this.array[i] = this.array[i+1];
        }

        this.array[this.size] = 0;
        if(this.array.length / 4 >=  this.size || this.array.length / 4 == 4){
            this.array = shrink();
        }

        return element;
    }


    public int size() {
        return size;
    }

    private Object[] grow() {
        Object[] newArr = new Object[this.array.length * 2];
        System.arraycopy(this.array, 0, newArr, 0, this.array.length);
        return newArr;
    }
    private Object[] shrink() {
       Object[] newArr = new Object[this.array.length / 2];
        System.arraycopy(this.array, 0, newArr, 0, this.size);
        return newArr;
    }


}
