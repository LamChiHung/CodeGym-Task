public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(0);
        list.add(1, 9);
        System.out.println(list.toString());
    }
}