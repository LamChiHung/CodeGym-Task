package service.bill_service;

import database.DataBase;
import entity.bill_imp.Bill;
import service.cart_service.CartService;
import util.write_data.WriteBillData;

public class BillService {
    private static BillService billService;

    private BillService() {

    }

    public static BillService getBillService() {
        if (billService == null) {
            billService = new BillService();
            return billService;
        } else return billService;
    }

    public void createBill(int totalMoney) {
        String infomation = CartService.getCartService().viewCart();
        String formatedInformation = infomation.replaceAll(",", ";");
//        int totalmoney = CartService.getCartService().calculatorCartTotalMoney();
        Bill bill = new Bill(formatedInformation, totalMoney);
        DataBase.billMap.put(bill.getBillID(), bill);
        WriteBillData.getWriteBillData().writeData();
    }

    public void viewBillforClient() {
        DataBase.billMap.forEach((key, value) -> {
            if (value.getClientID().equals(DataBase.currentClient.getClientID())) {
                System.out.println(value.toString());
            }
        });
    }

    public void viewBillforSeller() {
        DataBase.billMap.forEach((key, value) -> {
            if (value.getSellerID().equals(DataBase.currentSeller.getSellerID())) {
                System.out.println(value.toString());
            }
        });
    }
}
