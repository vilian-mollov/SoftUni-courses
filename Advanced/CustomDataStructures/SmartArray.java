package Workshop;

import java.util.function.Consumer;

public class SmartArray {

    int[] array;
    int size;

    public SmartArray() {
        array = new int[4];
        size = 0;
    }

    public void add(int element) {
        if (this.size == this.array.length) {
            this.array = grow();
        }
        this.array[size] = element;
        size++;
    }

    public void add(int index, int element) {
        validate(index);
        int lastIndex = this.size - 1;
        int latsElement = this.array[lastIndex];

        for (int i = lastIndex; i > index ; i--) {
            this.array[i] = this.array[i-1];
        }

        this.array[index] = element;

        add(latsElement);

    }




    public int get(int index) {
        validate(index);
        return this.array[index];
    }

    private void validate(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }


    public int remove(int index) {
        validate(index);
        int element = this.array[index];
        size--;


        for (int i = index; i < size ; i++) {
            this.array[i] = this.array[i+1];
        }

        this.array[this.size] = 0;
        if(this.array.length / 4 >=  this.size || this.array.length / 4 == 4){
            this.array = shrink();
        }

        return element;
    }


    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            int e = this.array[i];
            consumer.accept(e);
        }
    }

    public int size() {
        return size;
    }

    private int[] grow() {
        int[] newIntArr = new int[this.array.length * 2];
        System.arraycopy(this.array, 0, newIntArr, 0, this.array.length);
        return newIntArr;
    }
    private int[] shrink() {
        int[] newIntArr = new int[this.array.length / 2];
        System.arraycopy(this.array, 0, newIntArr, 0, this.size);
        return newIntArr;
    }


}
