package zg.solucoes.bussi;

/**
 * Created by Alex on 26/05/2017.
 */
public interface BaseShop {

    void add(String id);

    void remove(String id);

    Double getTotal();

    Double getTotalDiscount();

}
