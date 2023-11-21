package ss10_dsa_list.excercise.method_arraylist.service.impl;

import java.util.Arrays;

public class MyListService<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    public Object[] elements;


    public MyListService() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyListService(int capacity) {
        elements = new Object[capacity];
    }

    public boolean add(E e) {
        elements[size] = e;
        size++;
        return true;
    }

    public E remove(int index) {
        if (index < 0 || index > elements.length) {
            throw new
                    IllegalArgumentException("Lỗi index: " + index);
        }
        E element = (E) elements[index];
        if (size - 1 - index >= 0) System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
        elements[size - 1] = null;
        size--;
        return element;
    }

    public int size() {
        return size;
    }


    public int length() {
        return elements.length;
    }


    public MyListService<E> clone() {
        MyListService<E> v = new MyListService<>();
        v.elements = Arrays.copyOf(elements, size);
        v.size = size;
        return v;
    }

    public E get(int index) {
        return (E) elements[index];
    }

    public boolean contains(E e) {
        return this.indexOf(e) >= 0;
    }

    private int indexOf(E e) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (this.elements[i].equals(e)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new
                    IllegalArgumentException("minCapacity: " + minCapacity);
        }
    }

    public void add(int index, E element) {
        if (index > elements.length) {
            throw new
                    IllegalArgumentException("Lỗi index: " + index);
        } else if (elements.length == index + 1) {
            ensureCapacity(1);
        }
        if (elements[index] == null) {
            size++;
            elements[index] = element;
        } else {
            if (size == elements.length) {
                ensureCapacity(1);
            }
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;
            size++;
        }
    }


    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyListService<?> myList = (MyListService<?>) o;
        return size == myList.size && Arrays.equals(elements, myList.elements);
    }


}
