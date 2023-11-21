package ss17_io_binary_file_serialization.excercise.service.impl;

import ss17_io_binary_file_serialization.excercise.model.Product;
import ss17_io_binary_file_serialization.excercise.service.IProductService;
import ss17_io_binary_file_serialization.excercise.utils.ReadFileUtils;
import ss17_io_binary_file_serialization.excercise.utils.WriteFileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final String PATH = "src/ss17_io_binary_file_serialization/excercise/file/product.dat";
    public static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        List<Product> products = ReadFileUtils.readFIle(PATH);
        Product product = infoProduct();
        products.add(product);
        WriteFileUtils.writeFile(PATH, products);
    }

    @Override
    public void display() {
        List<Product> list = ReadFileUtils.readFIle(PATH);
        for (Product product : list) {
            System.out.println(product);
        }

    }

    @Override
    public void search() {
        System.out.println("Nhập vào tên sản phẩm bạn muốn tìm");
        String nameSearch = scanner.nextLine();
        List<Product> list = ReadFileUtils.readFIle(PATH);
        for (Product product : list) {
            if (nameSearch.equals(product.getProductName())) {
                System.out.println(product);
            }
        }


    }


    public static Product infoProduct() {

        System.out.println("Nhập vào mã sản phẩm");
        String productCode = scanner.nextLine();

        System.out.println("Nhập vào tên sản phẩm");
        String productName = scanner.nextLine();

        System.out.println("Nhập vào Hãng sản xuất");
        String manufacturer = scanner.nextLine();

        System.out.println("Nhập vào mô tả sản phẩm");
        String productInfo = scanner.nextLine();

        System.out.println("Nhập vào giá sản phẩm");
        int price;
        while (true) {
            try {
                price = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        List<Product> list = new ArrayList<>();
        list.add(new Product(productCode, productName, manufacturer, price, productInfo));
        WriteFileUtils.writeFile(PATH, list);
        return new Product(productCode, productName, manufacturer, price, productInfo);
    }
}
