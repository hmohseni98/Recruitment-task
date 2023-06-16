package com.example.review.service.base;

import com.example.review.model.base.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity<ID>, ID extends Serializable> {

    void save(T t);

    void delete(T t);

    void update(T t);

    T findById(ID id);

    List<T> findAll();

}
