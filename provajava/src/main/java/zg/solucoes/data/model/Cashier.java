package zg.solucoes.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 26/05/2017.
 */
public class Cashier {

    private Double total;
    private Map<String, Double> priceByProduct;
    private Map<String, Long> totalByProduct;
    private List<Product> totalProducts;

    public Cashier() {
        total = 0.0;
        priceByProduct = new HashMap<String, Double>();
        totalByProduct = new HashMap<String, Long>();
        totalProducts = new ArrayList<Product>();
    }

    public Cashier(Double total, Map<String, Double> priceByProduct, Map<String, Long> totalByProduct, List<Product> totalProducts) {
        this.total = total;
        this.priceByProduct = priceByProduct;
        this.totalByProduct = totalByProduct;
        this.totalProducts = totalProducts;
    }

    public Map<String, Long> getTotalByProduct() {
        return totalByProduct;
    }

    public void setTotalByProduct(Map<String, Long> totalByProduct) {
        this.totalByProduct = totalByProduct;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Map<String, Double> getPriceByProduct() {
        return priceByProduct;
    }

    public void setPriceByProduct(Map<String, Double> priceByProduct) {
        this.priceByProduct = priceByProduct;
    }

    public List<Product> getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(List<Product> totalProducts) {
        this.totalProducts = totalProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cashier cashier = (Cashier) o;

        if (total != null ? !total.equals(cashier.total) : cashier.total != null) return false;
        if (priceByProduct != null ? !priceByProduct.equals(cashier.priceByProduct) : cashier.priceByProduct != null)
            return false;
        if (totalByProduct != null ? !totalByProduct.equals(cashier.totalByProduct) : cashier.totalByProduct != null)
            return false;
        return totalProducts != null ? totalProducts.equals(cashier.totalProducts) : cashier.totalProducts == null;
    }

    @Override
    public int hashCode() {
        int result = total != null ? total.hashCode() : 0;
        result = 31 * result + (priceByProduct != null ? priceByProduct.hashCode() : 0);
        result = 31 * result + (totalByProduct != null ? totalByProduct.hashCode() : 0);
        result = 31 * result + (totalProducts != null ? totalProducts.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cashier{" +
                "total=" + total +
                ", priceByProduct=" + priceByProduct +
                ", totalByProduct=" + totalByProduct +
                ", totalProducts=" + totalProducts +
                '}';
    }
}
