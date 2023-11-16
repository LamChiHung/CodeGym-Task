package com.codegym;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        CollectionOperations collectionOperations = new CollectionOperationsAdapter();
        Client client = new Client(collectionOperations);
        Set<Integer> set = new HashSet <>();
        for (int i = 0; i < 12; i++) {
            set.add(i);
        }
        client.printMaxValue(set);
    }
}
