package zg.solucoes.data.model;

/**
 * Created by Alex on 26/05/2017.
 */
public class Item {

    private Long totalProducts;
    private Product product;

    public Item() {
    }

    public Item(Long totalProducts, Product product) {
        this.totalProducts = totalProducts;
        this.product = product;
    }

    public Long getTotalProducts() {
        return totalProducts;
    }

    public void setTotalProducts(Long totalProducts) {
        this.totalProducts = totalProducts;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (totalProducts != null ? !totalProducts.equals(item.totalProducts) : item.totalProducts != null)
            return false;
        return product != null ? product.equals(item.product) : item.product == null;
    }

    @Override
    public int hashCode() {
        int result = totalProducts != null ? totalProducts.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "totalProducts=" + totalProducts +
                ", product=" + product +
                '}';
    }
}
