public class Main {
    public static void main(String[] args) {
        SortList sortList = new SortList(new BubleSort());
        sortList.add("A");
        sortList.add("C");
        sortList.add("D");
        sortList.useSort();
    }
}