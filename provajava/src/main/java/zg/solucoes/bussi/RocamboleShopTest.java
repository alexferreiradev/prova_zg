package zg.solucoes.bussi;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import zg.solucoes.data.model.GroupPromotion;
import zg.solucoes.data.model.PayLessAndCarryMorePromotion;
import zg.solucoes.data.model.Product;
import zg.solucoes.data.model.Promotion;
import zg.solucoes.data.model.dao.RocamboleProductDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 26/05/2017.
 */
public class RocamboleShopTest {

    @Mock private RocamboleProductDao productDao;
    @InjectMocks private RocamboleShop shop;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        List<Promotion> promotions = new ArrayList<Promotion>();
        GroupPromotion groupPromotion = new GroupPromotion();

        promotions = new ArrayList<Promotion>();
        promotions.add(groupPromotion);
        groupPromotion.setMinGroup(3L);
        groupPromotion.setPriceWithDiscount(130.0);
        Mockito.when(productDao.get("A")).thenReturn(new Product("A", 50.0, promotions));

        promotions = new ArrayList<Promotion>();
        promotions.add(groupPromotion);
        groupPromotion.setMinGroup(2L);
        groupPromotion.setPriceWithDiscount(45.0);
        Mockito.when(productDao.get("B")).thenReturn(new Product("B", 30.0, promotions));

        promotions = new ArrayList<Promotion>();
        PayLessAndCarryMorePromotion carryMorePromotion = new PayLessAndCarryMorePromotion();
        carryMorePromotion.setCarryTotal(3L);
        carryMorePromotion.setPayTotal(2L);
        promotions.add(carryMorePromotion);
        Mockito.when(productDao.get("C")).thenReturn(new Product("C", 20.0, promotions));

        promotions = new ArrayList<Promotion>();
        Mockito.when(productDao.get("D")).thenReturn(new Product("D", 15.0, promotions));
    }

    @Test
    public void pdfTest() {
        // Teste 1
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(50.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(100.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(130.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(180.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(230.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(260.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(40.0));
        shop.remove("A");
        Assert.assertEquals(shop.getTotal(), new Double(230.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));

        // Teste 2
        shop.add("D");
        Assert.assertEquals(shop.getTotal(), new Double(15.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(65.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("B");
        Assert.assertEquals(shop.getTotal(), new Double(95.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(145.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("B");
        Assert.assertEquals(shop.getTotal(), new Double(160.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(15.0));
        shop.add("A");
        Assert.assertEquals(shop.getTotal(), new Double(190.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(35.0));
        shop.remove("A");
        Assert.assertEquals(shop.getTotal(), new Double(160.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(15.0));
        shop.remove("B");
        Assert.assertEquals(shop.getTotal(), new Double(145.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
// Teste 3
        shop.add("C");
        Assert.assertEquals(shop.getTotal(), new Double(20.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("C");
        Assert.assertEquals(shop.getTotal(), new Double(40.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("C");
        Assert.assertEquals(shop.getTotal(), new Double(40.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.add("C");
        Assert.assertEquals(shop.getTotal(), new Double(60.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.remove("C");
        Assert.assertEquals(shop.getTotal(), new Double(40.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(20.0));
        shop.remove("C");
        Assert.assertEquals(shop.getTotal(), new Double(40.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        // Teste 4
        shop.add("C");
        Assert.assertEquals(shop.getTotal(), new Double(20.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("B");
        Assert.assertEquals(shop.getTotal(), new Double(30.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
        shop.add("B");
        Assert.assertEquals(shop.getTotal(), new Double(45.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(15.0));
        shop.remove("B");
        Assert.assertEquals(shop.getTotal(), new Double(30.0));
        Assert.assertEquals(shop.getTotalDiscount(), new Double(0.0));
    }
}
