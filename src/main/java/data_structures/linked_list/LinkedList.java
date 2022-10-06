package data_structures.linked_list;

import java.lang.reflect.Array;

public class LinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;
    private final Class<T> clazz;

    public LinkedList(Class<T> clazz) {
        this.head = new Node<>(null);
        this.tail = null;
        this.length = 0;
        this.clazz = clazz;
    }

    public void append(T value) {
        if (length == 0) {
            head.setValue(value);
            this.tail = head;
        }
        else {
            Node<T> newNode = new Node<>(value);
            tail.setNext(newNode);
            tail = newNode;
        }
        length++;
    }

    public void prepend(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.setNext(head);
        head = newNode;
        length++;
    }

    public int getLength() {
        return length;
    }

    public T[] getList() {
        //noinspection unchecked
        T[] myList = (T[]) Array.newInstance(clazz, length);
        Node<T> current = this.head;
        int i = 0;
        while (current != null) {
            myList[i] = current.value;
            current = current.next;
            i++;
        }
        return myList;
    }

    public void insert(int index, T value) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node<T> newNode = new Node<>(value);
            newNode.next = current.next;
            current.next = newNode;
            length++;
        }
    }

    public void remove(int index) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = this.head.next;
            length--;
        } else {
            Node<T> current = head;
            int i;
            for (i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
            if (i == length - 1) {
                tail = current;
            }
        }
    }

    public LinkedList<T> reverse(LinkedList<T> linkedList) {
        LinkedList<T> newList = new LinkedList<>(clazz);
        Node<T> current = linkedList.head;
        while (current.next != null) {
            current = current.next;
            Node<T> newNode = new Node<>(current.value);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.length++;
        }
        return newList;
    }
}
