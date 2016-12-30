package com.propertysys.operation;

import java.util.List;

/**
 * Created by shenying on 16/12/29.
 */
public interface IBaseOperator<T> {
    T queryById(int id);
    List<T> queryAll();
    List<T> queryAll(String hql, Object[] args);
    List<T> queryAll(String hql, Object arg);
    List<T> queryAll(String hql);
    void insert(T t);
    void insertAll(List<T> list);
    void delete(T t);
    void delete(int id);
    void update(T t);
}
