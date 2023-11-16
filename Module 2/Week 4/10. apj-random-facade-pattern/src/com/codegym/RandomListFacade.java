package com.codegym;

import java.util.List;

public class RandomListFacade {
    public void printRandomEventList() {
        RandomList randomList = new RandomList();
        List <Integer> list = randomList.generateList(10, 1, 10);
        ListFilter listFilter = new ListFilter();
        List <Integer> listEven = listFilter.filterOdd(list);
        ListPrinter listPrinter = new ListPrinter();
        listPrinter.printList(listEven);
    }
}
