package data_structures.hashtable;

import lombok.ToString;

import java.util.ArrayList;

@ToString
public class HashTable {
    private ArrayList<Pair>[] data;
    private int currentLength;

    public HashTable(int size) {
        //noinspection unchecked
        this.data = new ArrayList[size];
        this.currentLength = 0;
    }

    public HashTable() {
        this(16);
    }

    private int hash(String data) {
        int hash = 0;
        for (int i = 0; i < data.length(); i++) {
            hash = (hash + data.charAt(i) * i) % data.length();
        }
        return hash;
    }

    public void set(String key, int value) {
        int address = hash(key);
        if (data[address] == null) {
            ArrayList<Pair> arrayAtAddress = new ArrayList<>();
            data[address] = arrayAtAddress;
            currentLength++;
        }
        Pair pair = new Pair(key, value);
        data[address].add(pair);
    }

    public Integer get(String key) {
        int address = hash(key);
        ArrayList<Pair> bucket = data[address];
        if (bucket != null) {
            for (Pair keyValue : bucket) {
                if (keyValue.getKey().equals(key)) {
                    return keyValue.getValue();
                }
            }
        }
        return null;
    }

    public void delete(String key) {
        int address = hash(key);
        if (data[address] != null) {
            ArrayList<Pair> bucket = data[address];
            if (bucket.size() == 1) {
                data[address] = null;
            }
            else {
                ArrayList<Pair> tmp = new ArrayList<>();
                for (Pair keyValue : bucket) {
                    if (keyValue.getKey().equals(key)) {
                        tmp.add(keyValue);
                    }
                }
                bucket.removeAll(tmp);
                data[address] = bucket;
            }
            currentLength--;
        }
    }

    public String[] keys() {
        ArrayList<Pair>[] bucket = data;
        String[] keysArray = new String[currentLength];
        int count = 0;
        for (ArrayList<Pair> keyValues : bucket) {
            if (keyValues != null) {
                keysArray[count++] = keyValues.get(0).getKey();
            }
        }
        return keysArray;
    }
}
