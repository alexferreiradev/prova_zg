package zg.solucoes.data.model;

/**
 * Created by Alex on 26/05/2017.
 */
public class GroupPromotion implements Promotion {

    private Long minGroup;
    private Double priceWithDiscount;

    public GroupPromotion() {
    }

    public GroupPromotion(Long minGroup, Double priceWithDiscount) {
        this.minGroup = minGroup;
        this.priceWithDiscount = priceWithDiscount;
    }

    public Double applyDiscount(Long total, Product product) {
        Long totalWithDiscount = (total/this.minGroup);
        Long totalWithoutDiscount = (total%this.minGroup);
        Double unitPrice = product.getUnitPrice();
        double totalPrice = totalWithDiscount * priceWithDiscount;
        totalPrice += totalWithoutDiscount * unitPrice;

        return totalPrice;
    }

    public Long getMinGroup() {
        return minGroup;
    }

    public void setMinGroup(Long minGroup) {
        this.minGroup = minGroup;
    }

    public Double getPriceWithDiscount() {
        return priceWithDiscount;
    }

    public void setPriceWithDiscount(Double priceWithDiscount) {
        this.priceWithDiscount = priceWithDiscount;
    }
}
