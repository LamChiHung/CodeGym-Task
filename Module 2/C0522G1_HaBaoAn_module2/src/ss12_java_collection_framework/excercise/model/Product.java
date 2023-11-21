package ss12_java_collection_framework.excercise.model;

public class Product implements Comparable<Product>{
    private String productCode;
    private String productName;
    private String productInfo;
    private int price;

    public Product() {
    }

    public Product(String productCode, String productName, String productInfor,int price) {
        this.productCode = productCode;
        this.productName = productName;
        this.productInfo = productInfor;
        this.price = price;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sản phẩm " +
                "Mã sản phẩm: " + getProductCode() +
                ", Tên sản phẩm: " + getProductName() +
                ", Thông tin sản phẩm: " + getProductInfo() +
                ", Giá sản phẩm: "+ getPrice();
    }

    @Override
    public int compareTo(Product o) {
        return getPrice()-o.getPrice();

    }
}
