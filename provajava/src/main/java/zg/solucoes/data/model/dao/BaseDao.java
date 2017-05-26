package zg.solucoes.data.model.dao;

import java.util.List;

/**
 * Created by Alex on 26/05/2017.
 */
public interface BaseDao<ModelType> {

    void add(ModelType model);
    void remove(ModelType model);
    void update(ModelType model, int index);
    ModelType get(String key);
    List<ModelType> list();
}
