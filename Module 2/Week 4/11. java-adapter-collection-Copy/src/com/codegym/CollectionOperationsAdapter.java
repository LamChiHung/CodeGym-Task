package com.codegym;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CollectionOperationsAdapter implements  CollectionOperations{

    @Override
    public int findMax(Set <Integer> numbers) {
        List <Integer> list = new ArrayList <>(numbers);
        CollectionUtils collectionUtils = new CollectionUtils();
        return collectionUtils.findMax(list);
    }
}
