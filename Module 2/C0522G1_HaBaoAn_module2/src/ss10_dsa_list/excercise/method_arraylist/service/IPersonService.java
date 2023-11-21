package ss10_dsa_list.excercise.method_arraylist.service;

public interface IPersonService<E> {
    void findAll();

    void clear();

    void ensureCapacity(int minCapacity);

    boolean add(E e);

    E remove(int index);

    E get(int index);

    
}
