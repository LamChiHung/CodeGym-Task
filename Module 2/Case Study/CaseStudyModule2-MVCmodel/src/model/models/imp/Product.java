package model.models.imp;

import main.StoreMain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Product implements Serializable {
    private String name;
    private String store;
    private int unitPrice;
    private int numbers;
    private int promote;
    private Map <String, Double> starMap;
    private double star;
    private Map <String, String> commentMap;
    private int numbersOfSold;

    public Product(String name, int unitPrice, int numbers) {
        this.name = name;
        this.store = StoreMain.currentSeller.getUsername();
        this.unitPrice = unitPrice;
        this.numbers = numbers;
        this.promote = 0;
        this.star = 0;
        this.starMap = new HashMap <>();
        this.commentMap = new HashMap <>();
        this.numbersOfSold = 0;
    }

    public Map <String, Double> getStarMap() {
        return starMap;
    }

    public void setStarMap(Map <String, Double> starMap) {
        this.starMap = starMap;
    }

    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    public Map <String, String> getCommentMap() {
        return commentMap;
    }

    public void setCommentMap(Map <String, String> commentMap) {
        this.commentMap = commentMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(int numbers) {
        this.numbers = numbers;
    }

    public int getPromote() {
        return promote;
    }

    public void setPromote(int promote) {
        this.promote = promote;
    }

    public int getNumbersOfSold() {
        return numbersOfSold;
    }

    public void setNumbersOfSold(int numbersOfSold) {
        this.numbersOfSold = numbersOfSold;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", store='" + store + '\'' +
                ", unitPrice=" + unitPrice +
                ", numbers=" + numbers +
                ", promote=" + promote +
                ", star=" + star +
                ", numbersOfSold=" + numbersOfSold +
                '}';
    }
}
