package zg.solucoes.data.model.dao;

import zg.solucoes.data.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 26/05/2017.
 */
public class RocamboleProductDao implements BaseDao<Product> {
    private List<Product> cache;

    public RocamboleProductDao() {
        cache = new ArrayList<Product>();
    }

    public void add(Product model) {
        cache.add(model);
    }

    public void remove(Product model) {
        cache.remove(model);
    }

    public void update(Product model, int index) {
        cache.add(index, model);
    }

    public Product get(String key) {
        for (Product product : cache) {
            if (product.getId().equalsIgnoreCase(key))
                return product;
        }
        return null;
    }

    public List<Product> list() {
        return cache;
    }
}
