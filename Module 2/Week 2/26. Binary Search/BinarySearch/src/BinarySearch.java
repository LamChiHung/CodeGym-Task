public class BinarySearch {
    public static int binnarySearch(int[] list, int key) {
        int low = 0;
        int hight = list.length - 1;
        while (hight >= low) {
            int mid = (hight + low) / 2;
            if (key < list[mid]) {
                hight = mid - 1;
            } else if (key > list[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }
}
