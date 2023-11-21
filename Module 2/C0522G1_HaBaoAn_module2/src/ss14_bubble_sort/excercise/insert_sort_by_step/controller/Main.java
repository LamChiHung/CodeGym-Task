package ss14_bubble_sort.excercise.insert_sort_by_step.controller;

import ss14_bubble_sort.excercise.insert_sort_by_step.model.InsertSotByStep;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập vào số phần tử của mảng");
        int input = Integer.parseInt(scanner.nextLine());

        int[] arr = new int[input];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        System.out.println("Mảng đã nhập " + Arrays.toString(arr));

        InsertSotByStep.insertSortByStep(arr);
        System.out.println("Mảng sau khi sắp xếp "+Arrays.toString(arr));
    }
}
