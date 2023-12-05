package util;

import util.write_data.WriteBillData;
import util.write_data.WriteCartData;
import util.write_data.WriteCartItemData;
import util.write_data.WriteClientData;
import util.write_data.WriteClientLockedData;
import util.write_data.WriteClientWalletData;
import util.write_data.WriteClientWalletLogData;
import util.write_data.WriteCouponData;
import util.write_data.WriteProductData;
import util.write_data.WriteSellerData;
import util.write_data.WriteSellerLockedData;
import util.write_data.WriteSellerStorageData;
import util.write_data.WriteSellerWalletData;
import util.write_data.WriteSellerWalletLogData;
import util.write_data.WriteStorageItemData;

public class WriteAllData {
    private static WriteAllData writeAllData;

    private WriteAllData() {

    }

    public static WriteAllData getWriteAllData() {
        if (writeAllData == null) {
            writeAllData = new WriteAllData();
            return writeAllData;
        } else return writeAllData;
    }

    public void writeData() {
        WriteSellerData.getWriteSellerData().writeData();

        WriteSellerStorageData.getWriteSellerStorageData().writeData();

        WriteSellerLockedData.getWriteSellerData().writeData();

        WriteSellerWalletData.getWriteSellerWalletData().writeData();

        WriteClientData.getWriteClientData().writeData();

        WriteCartData.getWriteCartData().writeData();

        WriteClientWalletData.getWriteClientWalletData().writeData();

        WriteClientLockedData.getWriteClientData().writeData();

        WriteProductData.getWriteProductData().writeData();

        WriteStorageItemData.getWriteStorageItemData().writeData();

        WriteCouponData.getWriteCouponData().writeData();

        WriteCartItemData.getWriteCartItemData().writeData();

        WriteClientWalletLogData.getWriteClientWalletLogData().writeData();

        WriteSellerWalletLogData.getWriteSellerWalletLogData().writeData();
        
        WriteBillData.getWriteBillData().writeData();
    }
}
