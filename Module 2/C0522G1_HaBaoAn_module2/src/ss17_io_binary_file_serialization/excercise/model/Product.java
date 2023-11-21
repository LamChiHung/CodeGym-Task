package ss17_io_binary_file_serialization.excercise.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String productCode;
    private String productName;
    private String manufacturer;
    private int price;
    private String productInfo;

    public Product() {
    }

    public Product(String productCode, String productName, String manufacturer, int price, String productInfo) {
        this.productCode = productCode;
        this.productName = productName;
        this.manufacturer = manufacturer;
        this.price = price;
        this.productInfo = productInfo;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }



    @Override
    public String toString() {
        return "Product:" +
                " Product Code: " + productCode +
                ", Product Name: " + productName +
                ", Manufacturer" + manufacturer +
                ", Price:" + price +
                ", Product Info: " + productInfo;
    }


}
