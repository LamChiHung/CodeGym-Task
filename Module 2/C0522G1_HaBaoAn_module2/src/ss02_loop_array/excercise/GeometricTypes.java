package ss02_loop_array.excercise;

import java.util.Scanner;

public class GeometricTypes {
    public static void main(String[] args) {
        int choice = -1;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu");
            System.out.println("1. In ra tứ giác");
            System.out.println("2. In ra 4 hình tam giác vuông ");
            System.out.println("3.In ra hình tam giác đều ");
            System.out.println("0. Thoát chương trình");
            System.out.println("Nhập vào lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào chiều rộng hình tứ giác");
                    int length = scanner.nextInt();
                    System.out.println("Nhập vào chiều dài hình tứ giác");
                    int width = scanner.nextInt();
                    for (int i = 1; i <= length; i++) {
                        for (int j = 1; j <= width; j++) {
//                            if (i == 1 || i == length || j == 1 || j == width) {
                            System.out.print("*");
//                            } else {
                            System.out.print(" ");
//                            }
                        }
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    System.out.println("Nhập vào chiều cao tam giác");
                    int height = scanner.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = height; j > i; j--) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < height; j++) {
                            if (j - i >= 0) {
                                System.out.print(" * ");
                            } else {
                                System.out.print("   ");
                            }
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < height; j++) {
                            if (i + j < height - 1) {
                                System.out.print("   ");
                            } else {
                                System.out.print(" * ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Nhập vào chiều cao tam giác");
                    int hight = scanner.nextInt();
                    for (int i = 0; i < hight; i++) {
                        for (int j = 0; j < 2 * hight - 1; j++) {
                            if (i + j < hight - 1 || j - i > hight - 1) {
                                System.out.print(" ");
                            } else {
                                System.out.print("*");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Không có lựa chọn này, xin nhập lại");
            }
        }
    }
}
