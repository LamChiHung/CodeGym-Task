package homework1.service;

import java.io.IOException;
import java.util.List;

public interface IPersonService<E> {
    void add() throws IOException;

    void remove();

    void display();

    void sortByName();
}
