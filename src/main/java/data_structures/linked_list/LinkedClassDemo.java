package data_structures.linked_list;

import java.util.Arrays;

public class LinkedClassDemo {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>(Object.class);
        list.append("kk");
        list.append("ki");
        list.append("i");
        list.append("k");
        System.out.println(Arrays.toString(list.getList()));
        list.remove(3);
        System.out.println(list.getLength());
        System.out.println(Arrays.toString(list.getList()));
    }
}
