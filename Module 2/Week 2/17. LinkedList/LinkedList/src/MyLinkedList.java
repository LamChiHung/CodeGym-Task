public class MyLinkedList <E> {
    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node head;
    private Node tail;
    private int numNodes = 0;

    public MyLinkedList(Object data) {
        head = new Node(data);
        tail = head;
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node temp = tail;
        tail = new Node(data);
        temp.next = tail;
        numNodes++;
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == numNodes) {
            addLast(data);
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node temp2 = new Node(data);
            temp2.next = temp.next;
            temp.next = temp2;
            numNodes++;
        }
    }

    @Override
    public String toString() {
        Node temp = head;
        String result = "";
        while (temp != null) {
            result += temp.toString() + "\t";
            temp = temp.next;
        }
        return result;
    }
}
