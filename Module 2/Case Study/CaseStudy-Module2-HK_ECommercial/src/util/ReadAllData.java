package util;

import util.read_data.ReadBillData;
import util.read_data.ReadCartData;
import util.read_data.ReadCartItemData;
import util.read_data.ReadClientData;
import util.read_data.ReadClientWalletData;
import util.read_data.ReadClientWalletLogData;
import util.read_data.ReadCouponData;
import util.read_data.ReadLockedClientData;
import util.read_data.ReadLockedSellerData;
import util.read_data.ReadProductData;
import util.read_data.ReadSellerData;
import util.read_data.ReadSellerStorageData;
import util.read_data.ReadSellerWalletData;
import util.read_data.ReadSellerWalletLogData;
import util.read_data.ReadStorageItemData;

public class ReadAllData {
    private static ReadAllData readAllData;

    private ReadAllData() {

    }

    public static ReadAllData getReadAllData() {
        if (readAllData == null) {
            readAllData = new ReadAllData();
            return readAllData;
        } else return readAllData;
    }

    public void readData() {
        ReadSellerData.getReadSellerData().readData();

        ReadSellerStorageData.getReadSellerStorageData().readData();

        ReadLockedSellerData.getReadLockedSellerData().readData();

        ReadSellerWalletData.getReadSellerWalletData().readData();

        ReadClientData.getReadClientData().readData();

        ReadClientWalletData.getReadClientWalletData().readData();

        ReadCartData.getReadCartData().readData();

        ReadLockedClientData.getReadLockedClientData().readData();

        ReadProductData.getReadProductData().readData();

        ReadStorageItemData.getReadStorageItemData().readData();

        ReadCouponData.getReadCouponData().readData();

        ReadCartItemData.getReadCartItemData().readData();

        ReadClientWalletLogData.getReadClientWalletLogData().readData();

        ReadSellerWalletLogData.getReadSellerWalletLogData().readData();

        ReadBillData.getReadBillData().readData();
    }
}
