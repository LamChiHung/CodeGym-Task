package service.comparator;

import entity.storage.StorageItem;

import java.util.Comparator;

public class StorageItemComparator implements Comparator <StorageItem> {
    @Override
    public int compare(StorageItem i1, StorageItem i2) {
        return Integer.compare(i1.getCurrentUnitPrice(), i2.getCurrentUnitPrice());
    }
}
