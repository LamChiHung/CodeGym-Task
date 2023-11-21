package ss14_bubble_sort.excercise.insert_sort_by_step.model;

import java.util.Arrays;

public class InsertSotByStep {
    public static void insertSortByStep(int[] arr){
        int k=1;
        boolean Flag=false;
        for (int i = 1;i<arr.length;i++){
            int key = arr[i];
            int j;
            int indexInsert = 0;
            if (arr[i-1]<arr[i]){
                System.out.println(arr[i-1]+" nhỏ hơn "+arr[i]+" nên mảng giữ nguyên: "+ Arrays.toString(arr));
            }else {
                for (j=i-1;j>=0 && arr[j]>key;j--,k++){
                    System.out.println("Bước " +k+": lấy giá trị "+arr[j+1]+" gắn vào temp & dời "+arr[j]+" sang vị trí của "+arr[j+1]);
                    arr[j+1]=arr[j];
                    indexInsert=arr[j+1];
                    Flag=true;

                }
                arr[j+1]=key;
                if (Flag){
                    System.out.println("Chèn "+key+" vào vị trí cũ của "+indexInsert+" ta được: "+Arrays.toString(arr)+"\n");
                }
            }



        }
    }
}
