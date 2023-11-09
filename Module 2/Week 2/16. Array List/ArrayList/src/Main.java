public class Main {
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList <>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.add(3, 4);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
    }
}