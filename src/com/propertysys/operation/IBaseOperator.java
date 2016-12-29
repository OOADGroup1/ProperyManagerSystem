package com.propertysys.operation;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface IBaseOperator<T> {
    T queryById(int id);
    List<T> queryAll();
    void insert(T t);
    void delete(T t);
    void delete(int id);
    void update(T t);
}
