public class BinarySearch {
    public static int binnarySearch(int[] list, int left, int right, int key) {
        int low = left;
        int high = right;
        while (high >= low) {
            int mid = (right + left) / 2;
            if (key < list[mid]) {
                high = mid - 1;
            } else if (key > list[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return - 1;
    }
}
