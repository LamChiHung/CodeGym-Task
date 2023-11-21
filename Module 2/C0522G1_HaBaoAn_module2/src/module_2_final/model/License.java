package module_2_final.model;

public class License {
    private int numberSign;
    private String name;
    private String date;

    public License() {
    }

    public License(int numberSign, String name, String date) {
        this.numberSign = numberSign;
        this.name = name;
        this.date = date;
    }

    public int getNumberSign() {
        return numberSign;
    }

    public void setNumberSign(int numberSign) {
        this.numberSign = numberSign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public  String getInfo(){
        return String.format("%s,%s,%s",
                getNumberSign(),
                getName(),
                getDate());
    }

    @Override
    public String toString() {
        return
                " Số đăng kí: " + numberSign +
                " Tên chủ phương tiện: " + name + '\'' +
                " Ngày đăng kí: " + date;
    }
}
