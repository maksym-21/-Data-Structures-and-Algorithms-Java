package data_structures.hashtable;

import java.util.Arrays;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.set("red", 800);
        hashTable.set("eden", 150);
        hashTable.set("qwerty", 10000);
        System.out.println("value for key red: " + hashTable.get("red"));
        System.out.println("list of keys: " + Arrays.toString(hashTable.keys()));
        hashTable.delete("eden");
        System.out.println(hashTable);
    }
}
