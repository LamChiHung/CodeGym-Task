package ss12_java_collection_framework.excercise.controller;

import ss12_java_collection_framework.excercise.service.IProductService;
import ss12_java_collection_framework.excercise.service.impl.ProductService;

import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class MainController {
    public static void mainController() {
        Scanner scanner = new Scanner(System.in);
        ProductService iProductService = new ProductService();
        do {
            System.out.println("Chào mừng bạn đến với hệ thống quản lý sản phẩm \n" +
                    "Chọn chức năng theo số \n" +
                    "1. Thêm sản phẩm \n" +
                    "2. Xóa sản phẩm \n" +
                    "3. Sửa thông tin sản phẩm \n" +
                    "4. Hiển thị danh sách sản phẩm \n" +
                    "5. Tìm kiếm sản phẩm \n" +
                    "6. Sắp xếp sản phẩm theo thứ tự \n" +
                    "7. Thoát chương trình.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose){
                case 1:
                    iProductService.add();
                    break;
                case 2:
                    iProductService.remove();
                    break;
                case 3:
                    iProductService.recover();
                    break;
                case 4:
                    iProductService.display();
                    break;
                case 5:
                    iProductService.search();
                    break;
                case 6:
                    iProductService.sort();
                    break;
                case 7:
                    System.exit(1);
            }
        }while (true);
    }


}
