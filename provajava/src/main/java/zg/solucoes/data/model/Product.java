package zg.solucoes.data.model;

import java.util.List;

/**
 * Created by Alex on 26/05/2017.
 */
public class Product {

    private String id;
    private Double unitPrice;
    private List<Promotion> promotions;

    public Product() {
    }

    public Product(String id, Double unitPrice, List<Promotion> promotions) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.promotions = promotions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public List<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(List<Promotion> promotions) {
        this.promotions = promotions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        if (unitPrice != null ? !unitPrice.equals(product.unitPrice) : product.unitPrice != null) return false;
        return promotions != null ? promotions.equals(product.promotions) : product.promotions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (promotions != null ? promotions.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", unitPrice=" + unitPrice +
                ", promotions=" + promotions +
                '}';
    }
}
