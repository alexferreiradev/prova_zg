package zg.solucoes.bussi;

import zg.solucoes.data.model.Cashier;
import zg.solucoes.data.model.Product;
import zg.solucoes.data.model.Promotion;
import zg.solucoes.data.model.dao.RocamboleProductDao;

import java.util.Map;
import java.util.Set;

/**
 * Created by Alex on 26/05/2017.
 */
public class RocamboleShop implements BaseShop {

    private Cashier cashier;
    private RocamboleProductDao productDao;

    public RocamboleShop() {
        cashier = new Cashier();

        productDao = new RocamboleProductDao();
    }

    public void add(String id) {
        Product product = productDao.get(id);

        changeTotal(product, false);
    }

    public void remove(String id) {
        Product product = productDao.get(id);
        changeTotal(product, true);
    }

    public Double getTotal() {
        double total = 0;
        for (Double price : cashier.getPriceByProduct().values()) {
            total += price;
        }

        return total;
    }

    public Double getTotalDiscount() {
        double total = 0;
        Set<Map.Entry<String, Long>> entries = cashier.getTotalByProduct().entrySet();
        for (Map.Entry<String, Long> entry : entries) {
            Product product = productDao.get(entry.getKey());
            total += (product.getUnitPrice() * entry.getValue());
        }
        double diff = total - getTotal();

        return diff;
    }

    private void changeTotal(Product product, boolean isRemoved){
        String productId = product.getId();
        long totalProducts = 0L;
        if (cashier.getTotalByProduct().containsKey(productId))
            totalProducts = cashier.getTotalByProduct().get(productId);

        if (isRemoved){
            totalProducts -= 1;
            cashier.getTotalByProduct().put(productId, totalProducts);
            double priceOfProduct = applyPromotion(product);
            cashier.getPriceByProduct().put(productId, priceOfProduct);
            cashier.getTotalProducts().remove(product);
        }else{
            totalProducts += 1;
            cashier.getTotalByProduct().put(productId, totalProducts);
            double priceOfProduct = applyPromotion(product);
            cashier.getPriceByProduct().put(productId, priceOfProduct);
            cashier.getTotalProducts().add(product);
        }
    }

    private Double applyPromotion(Product product) {
        String productId = product.getId();
        long totalProducts = cashier.getTotalByProduct().get(productId);
        double lowerPrice = Double.MAX_VALUE;
        for (Promotion promotion : product.getPromotions()) {
            double price = promotion.applyDiscount(totalProducts, product);
            if (price < lowerPrice)
                lowerPrice = price;
        }
        if (lowerPrice == Double.MAX_VALUE){
            lowerPrice = totalProducts * product.getUnitPrice();
        }

        return lowerPrice;
    }
}
