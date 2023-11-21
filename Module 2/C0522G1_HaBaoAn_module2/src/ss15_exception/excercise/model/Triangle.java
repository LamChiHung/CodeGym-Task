package ss15_exception.excercise.model;

import ss15_exception.excercise.exception.IllegalTriangleException;

public class Triangle {
    private int aDouble;
    private int bDouble;
    private int cDouble;

    public Triangle() {
    }

    public Triangle(int aDouble, int bDouble, int cDouble) throws IllegalTriangleException {
        if (aDouble <= 0 || bDouble <= 0 || cDouble <= 0) {
            throw new IllegalTriangleException("Cạnh tam giác phải lớn hơn 0");
        } else
            if (aDouble + bDouble < cDouble || aDouble + cDouble < bDouble || bDouble + cDouble < aDouble) {
            throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại");
        } else
        {
            this.aDouble = aDouble;
            this.bDouble = bDouble;
            this.cDouble = cDouble;
        }
    }

    public int getaDouble() {
        return aDouble;
    }

    public void setaDouble(int aDouble) {
        this.aDouble = aDouble;
    }

    public int getbDouble() {
        return bDouble;
    }

    public void setbDouble(int bDouble) {
        this.bDouble = bDouble;
    }

    public int getcDouble() {
        return cDouble;
    }

    public void setcDouble(int cDouble) {
        this.cDouble = cDouble;
    }

    @Override
    public String toString() {
        return "Tam giác {" +
                "Cạnh thứ nhất = " + aDouble +
                ", Cạnh thứ hai = " + bDouble +
                ", Cạnh thứ ba = " + cDouble +
                '}';
    }
}