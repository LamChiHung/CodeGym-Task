package util.read_data;

import com.opencsv.CSVReader;
import database.DataBase;
import entity.Coupon;
import entity.coupon_imp.CouponMoney;
import entity.coupon_imp.CouponPercent;
import project_enum.CouponType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReadCouponData {
    private static ReadCouponData readCouponData;

    private ReadCouponData() {

    }

    public static ReadCouponData getReadCouponData() {
        if (readCouponData == null) {
            readCouponData = new ReadCouponData();
            return readCouponData;
        } else return readCouponData;
    }

    public void readData() {
        File file = new File(".\\src\\database\\seller\\coupon.csv");
        try {
            CSVReader csvReader = new CSVReader(new FileReader(file));
            String[] line;
            Coupon coupon;
            while ((line = csvReader.readNext()) != null) {
                if (line[2].equals("PERCENT")) {
                    coupon = new CouponPercent(line[0], UUID.fromString(line[1]), CouponType.valueOf(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), LocalDateTime.parse(line[6]), Long.parseLong(line[7]), LocalDateTime.parse(line[8]));
                } else {
                    coupon = new CouponMoney(line[0], UUID.fromString(line[1]), CouponType.valueOf(line[2]), Integer.parseInt(line[3]), Integer.parseInt(line[4]), Integer.parseInt(line[5]), LocalDateTime.parse(line[6]), Long.parseLong(line[7]), LocalDateTime.parse(line[8]));
                }
                DataBase.couponMap.put(coupon.getCouponID(), coupon);
            }
            csvReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
