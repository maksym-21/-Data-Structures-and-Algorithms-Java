package data_structures.array;

import java.lang.reflect.Array;

public class DynamicArray<T> {
    private T[] array;
    private int capacity;
    private int currentPosition;
    private final Class<T> clazz;

    public DynamicArray(Class<T> clazz, int capacity) {
        //noinspection unchecked
        this.array = (T[]) Array.newInstance(clazz, capacity);
        this.clazz = clazz;
        this.capacity = capacity;
    }

    public DynamicArray(Class<T> clazz) {
        this(clazz, 16);
    }

    public T get(int index) {
        // O(1)
        if (index >= 0 && index < capacity) {
            return array[index];
        }
        throw new IllegalArgumentException("Invalid index!");
    }

    public void add(T data) {
        // O(n)
        if (data == null) {
            throw new IllegalArgumentException("Data can not be null");
        }
        if (currentPosition < capacity) {
            array[currentPosition++] = data;
        }
        else {
            //noinspection unchecked
            T[] tmp = (T[]) Array.newInstance(clazz, capacity * 2);

            //noinspection ManualArrayCopy
            for (int i = 0; i < capacity; i++) {
                tmp[i] = array[i];
            }
            this.capacity *= 2;
            this.array = tmp;
            this.currentPosition += 1;
        }
    }

    public void replace(int index, T newData) {
        // O(1)
        if (newData == null) {
            throw new IllegalArgumentException("Data can not be null");
        }
        if (index >= 0 && index < capacity) {
            array[index] = newData;
        }
        else {
            throw new IllegalArgumentException("Invalid index!");
        }
    }

    public void delete() {
        //  O(1)
        if (capacity > 0) {
            array[currentPosition--] = null;
        }
        else {
            throw new RuntimeException("Array is empty!");
        }
    }

    public void deleteAt(int index) {
        // O(n)
        if (index >= 0 && index < capacity) {
            if (index == currentPosition - 1) {
                delete();
            }
            else {
                array[index] = null;
                //noinspection ManualArrayCopy
                for (int i = index; i < currentPosition - 1; i++) {
                    array[i] = array[i + 1];
                }
                currentPosition--;
            }
        }
        else {
            throw new IllegalArgumentException("Invalid index!");
        }
    }

    public T[] getArray() {
        // O(n)
        //noinspection unchecked
        T[] tmp = (T[]) Array.newInstance(clazz, currentPosition);
        //noinspection ManualArrayCopy
        for (int i = 0; i < currentPosition; i++) {
            tmp[i] = array[i];
        }
        return tmp;
    }

    public int length() {
        return currentPosition;
    }
}
