package ss17_io_binary_file_serialization.excercise.controller;

import ss17_io_binary_file_serialization.excercise.service.impl.ProductService;


import java.util.Scanner;

public class ProductController {
    public static void productController() {
        Scanner scanner = new Scanner(System.in);
        ProductService productService = new ProductService();
        do {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý sản phẩm \n" +
                    "1. Thêm mới sản phẩm \n" +
                    "2. Hiển thị danh sách sản phẩm \n" +
                    "3. Tìm kiếm sản phẩm \n" +
                    "4. Thoát chương trình ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    productService.add();
                    break;
                case 2:
                    productService.display();
                    break;
                case 3:
                    productService.search();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (true);
    }
}
