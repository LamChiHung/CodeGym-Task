package database;

import entity.Coupon;
import entity.bill_imp.Bill;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.lockedaccount_imp.LockedClient;
import entity.lockedaccount_imp.LockedSeller;
import entity.product.Product;
import entity.storage.Storage;
import entity.storage.StorageItem;
import entity.user_imp.Client;
import entity.user_imp.Seller;
import entity.wallet_imp.ClientWallet;
import entity.wallet_imp.ClientWalletLog;
import entity.wallet_imp.SellerWallet;
import entity.wallet_imp.SellerWalletLog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class DataBase {
    public static Map <UUID, Seller> sellerMap = new HashMap <>();
    public static Map <UUID, Client> clientMap = new HashMap <>();
    public static Map <UUID, Product> producttMap = new HashMap <>();
    public static Map <UUID, Bill> billMap = new HashMap <>();
    public static Map <UUID, Cart> cartMap = new HashMap <>();
    public static Map <UUID, CartItem> cartItemMap = new HashMap <>();
    public static Map <String, Coupon> couponMap = new HashMap <>();
    public static Map <UUID, Storage> storageMap = new HashMap <>();
    public static Map <UUID, StorageItem> storageItemMap = new HashMap <>();
    public static Map <UUID, ClientWallet> clientWalletMap = new HashMap <>();
    public static Map <UUID, SellerWallet> sellerWalletMap = new HashMap <>();
    public static Map <UUID, SellerWalletLog> sellerWalletLogMap = new HashMap <>();
    public static Map <UUID, ClientWalletLog> clientWalletLogMap = new HashMap <>();
    public static Seller currentSeller;
    public static Client currentClient;
    public static List <String> signInIncorrectSellerList = new ArrayList <>();
    public static List <String> signInIncorrectClientList = new ArrayList <>();
    public static int countSignInIncorrect;
    public static Map <UUID, LockedSeller> lockedSellerMap = new HashMap <>();
    public static Map <UUID, LockedClient> lockedClientMap = new HashMap <>();

}
