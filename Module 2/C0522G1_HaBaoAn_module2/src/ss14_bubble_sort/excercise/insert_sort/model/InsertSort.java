package ss14_bubble_sort.excercise.insert_sort.model;

public class InsertSort {
    public static void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j;
            for (j=i-1;j>=0 && arr[j]>key;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=key;
        }
    }
}
