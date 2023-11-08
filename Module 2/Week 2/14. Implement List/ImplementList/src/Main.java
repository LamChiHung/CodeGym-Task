public class Main {
    public static void main(String[] args) {
        MyList <Integer> listInterger = new MyList <Integer>();
        listInterger.add(0);
        listInterger.add(1);
        listInterger.add(2);
        listInterger.add(3);

        System.out.println(listInterger.get(0));
        System.out.println(listInterger.get(1));
        System.out.println(listInterger.get(2));
        System.out.println(listInterger.get(3));

    }
}