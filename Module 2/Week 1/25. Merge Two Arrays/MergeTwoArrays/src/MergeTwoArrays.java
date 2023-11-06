public class MergeTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {6,7,8,9};
        int size = arr1.length + arr2.length;
        int[] arr = new int[size];

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i< arr1.length){
                arr[i] = arr1[i];
            } else {
                arr[i] = arr2[j];
                j++;
            }
        }
        for (int element: arr){
            System.out.print(element + "\t");
        }
    }
}
