package ss04_class_object_in_java.excercise.stop_watch;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long[] arr = new long[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (long) Math.floor(Math.random() * 100000 - 50000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Bắt đầu: " + stopWatch.getStartTime());

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        stopWatch.stop();
        System.out.println("Kết thúc: " + stopWatch.getEndTime());
        System.out.println("Tổng thời gian: " + stopWatch.getElapsedTime());

    }
}
