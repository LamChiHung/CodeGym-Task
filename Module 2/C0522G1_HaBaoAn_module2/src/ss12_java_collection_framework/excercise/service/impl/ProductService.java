package ss12_java_collection_framework.excercise.service.impl;

import ss12_java_collection_framework.excercise.model.Product;
import ss12_java_collection_framework.excercise.service.IProductService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class ProductService implements IProductService {
   static ArrayList<Product> productArrayList = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    static {
        productArrayList.add(new Product("1","Đồ chơi","Không có gì",10000));
        productArrayList.add(new Product("2","Đồ chơi","Không có gì",11000));
        productArrayList.add(new Product("3","Đồ chơi","Không có gì",12000));
        productArrayList.add(new Product("4","Đồ chơi","Không có gì",13000));
        productArrayList.add(new Product("5","Đồ chơi","Không có gì",14000));
        productArrayList.add(new Product("6","Đồ chơi","Không có gì",16000));
        productArrayList.add(new Product("7","Đồ chơi","Không có gì",100000));
    }

    @Override
    public void add() {
        Product product = inforProduct();
        productArrayList.add(product);
        System.out.println("Thêm mới sản phẩm thành công");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập mã sản phẩm cần xóa");
        String idRemove = scanner.nextLine();
        boolean isFlag = false;
        for (Product products : productArrayList) {
            if (Objects.equals(idRemove, products.getProductCode())) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm này \n" +
                        " 1. Có \n" +
                        " 2. Không \n");
                int yesNo = Integer.parseInt(scanner.nextLine());
                if (yesNo == 1) {
                    productArrayList.remove(products);
                    System.out.println("Đã xóa sản phẩm");
                }
                isFlag = true;
                break;
            }
        }
        if (!isFlag) {
            System.out.println("Không tìm thấy mã sản phẩm bạn nhập");
        }
    }

    @Override
    public void recover() {
        System.out.println("Mời bạn nhập mã sản phẩm cần sửa");
        String idRecover = scanner.nextLine();
        boolean isFlag = false;
        for (int i = 0; i < productArrayList.size(); i++) {
            if (idRecover.equals(productArrayList.get(i).getProductCode())) {
                System.out.println("Bạn có chắc muốn sửa thông tin sản phẩm này \n" +
                        " 1. Có \n" +
                        " 2. Không ");
                int yesNo = Integer.parseInt(scanner.nextLine());
                if (yesNo == 1) {
                    productArrayList.set(i, inforProduct());
                    System.out.println("Đã cập nhật sản phẩm");
                }
                isFlag = true;
                break;
            }
        }
        if (!isFlag) {
            System.out.println("Không tìm thấy mã sản phẩm bạn nhập");
        }

    }

    @Override
    public void search() {
        System.out.println("Mời bạn nhập tên sản phẩm muốn tìm");
        String searchName = scanner.nextLine();
        for (Product product : productArrayList) {
            if (searchName.equals(product.getProductName())) {
                System.out.println(product);
            }
        }

    }

    @Override
    public void display() {
        for (Product product : productArrayList) {
            System.out.println(product);
        }

    }

    @Override
    public void sort() {
        System.out.println("Bạn muốn xếp theo thứ tự \n" +
                "1. Tăng dần \n" +
                "2. Giảm dần");
        int choose = Integer.parseInt(scanner.nextLine());
        if (choose ==1){
            productArrayList.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o1.getPrice() - o2.getPrice();
                }
            });
        }else {
            productArrayList.sort(new Comparator<Product>() {
                @Override
                public int compare(Product o1, Product o2) {
                    return o2.getPrice() - o1.getPrice();
                }
            });
        }
    }

    public static Product inforProduct() {
        System.out.println("Nhập vào mã sản phẩm");
        String id = scanner.nextLine();
        System.out.println("Nhập vào tên sản phẩm ");
        String name = scanner.nextLine();
        System.out.println("Nhập vào thông tin sản phẩm");
        String infor = scanner.nextLine();
        System.out.println("Nhập vào giá sản phẩm");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, infor, price);
    }
}
