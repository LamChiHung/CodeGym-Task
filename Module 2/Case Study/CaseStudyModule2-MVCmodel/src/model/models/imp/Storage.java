package model.models.imp;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Storage implements Serializable {
    private Map <String, Product> productMap;

    public Storage() {
        productMap = new HashMap <>();
    }

    public Map <String, Product> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map <String, Product> productMap) {
        this.productMap = productMap;
    }
}
