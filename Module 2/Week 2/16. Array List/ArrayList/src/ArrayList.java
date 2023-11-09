import java.util.Arrays;

public class ArrayList <E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
    }

    public void add(int index, E element) {
        size++;
        if (size >= elements.length) {
            int newElementLength = elements.length * 2;
            elements = Arrays.copyOf(elements, newElementLength);
        }
        if (index < size) {
            elements[index] = element;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public E remove(int index) {
        Object result = null;
        if (index < size) {
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            result = elements[size - 1];
            elements[size - 1] = null;
            elements = Arrays.copyOf(elements, elements.length - 1);
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }
        return (E) result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += String.valueOf(elements[i]) + "\t";
        }
        return result;
    }
}
