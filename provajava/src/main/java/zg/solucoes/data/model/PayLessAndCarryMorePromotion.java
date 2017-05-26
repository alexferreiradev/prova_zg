package zg.solucoes.data.model;

/**
 * Created by Alex on 26/05/2017.
 */
public class PayLessAndCarryMorePromotion implements Promotion {

    private Long carryTotal;
    private Long payTotal;

    public PayLessAndCarryMorePromotion() {
    }

    public PayLessAndCarryMorePromotion(Long carryTotal, Long payTotal) {
        this.carryTotal = carryTotal;
        this.payTotal = payTotal;
    }

    public Double applyDiscount(Long total, Product product) {
        Long totalWithDiscount = (total/this.carryTotal);
        Long totalWithoutDiscount = (total%this.carryTotal);
        Double unitPrice = product.getUnitPrice();
        double totalPrice = totalWithDiscount * payTotal * unitPrice;
        totalPrice += totalWithoutDiscount * unitPrice;

        return totalPrice;
    }

    public Long getCarryTotal() {
        return carryTotal;
    }

    public void setCarryTotal(Long carryTotal) {
        this.carryTotal = carryTotal;
    }

    public Long getPayTotal() {
        return payTotal;
    }

    public void setPayTotal(Long payTotal) {
        this.payTotal = payTotal;
    }
}
