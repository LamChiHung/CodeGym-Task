import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyStack <T> {
    private LinkedList <T> stack;

    public MyStack() {
        stack = new LinkedList <>();
    }

    public void push(T element) {
        stack.addFirst(element);
    }

    public T pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return stack.removeFirst();
        }
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

}
