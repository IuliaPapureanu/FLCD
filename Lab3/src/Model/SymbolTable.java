package Model;

import Model.HashtablePosition;

import java.util.ArrayList;

public class SymbolTable {
    private ArrayList<ArrayList<String>> elements;
    private int size;

    public SymbolTable(int size) {
        this.size = size;
        this.elements = new ArrayList<>();
        for(int i=0; i<size; ++i)
            this.elements.add(new ArrayList<>());
    }

    public int getSize() {
        return size;
    }

    private int hash(String key) {
//        the hash function adds the ASCII codes of the key and divides by the size of the hashtable
        int sum = 0;
        for(int i=0;i< key.length();++i){
            char c = key.charAt(i);
            int ascii = (int)c;
            sum += ascii;
        }
        return sum % size;
    }

    public HashtablePosition add(String key){

        int hashedKey = hash(key);

        if(!elements.get(hashedKey).contains(key)){
            elements.get(hashedKey).add(key);
            return new HashtablePosition(hashedKey,elements.get(hashedKey).indexOf(key));
        }
        return new HashtablePosition(hashedKey,elements.get(hashedKey).indexOf(key));
        //return the existing position if the element already exists
    }

    public HashtablePosition search(String key){
        if(elements.get(hash(key)).contains(key))
            return new HashtablePosition(hash(key),elements.get(hash(key)).indexOf(key));
        return null;
    }
    public boolean contains(String key){
        int hashValue = hash(key);

        return elements.get(hashValue).contains(key);
    }

    public Pair<Integer, Integer> getPosition(String key){
        if (this.contains(key)){
            int listPosition = this.hash(key);
            int listIndex = 0;
            for(String el:this.elements.get(listPosition)) {
                if (!el.equals(key))
                    listIndex++;
                else
                    break;
            }

            return new Pair<>(listPosition, listIndex);
        }
        return new Pair<>(-1, -1);
    }

}
