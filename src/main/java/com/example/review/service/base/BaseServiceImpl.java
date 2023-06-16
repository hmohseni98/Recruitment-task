package com.example.review.service.base;

import com.example.review.model.base.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity<ID>, ID extends Serializable, R extends JpaRepository<T, ID>>
        implements BaseService<T, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public void save(T t) {
        repository.save(t);
    }

    @Override
    public void delete(T t) {
        repository.delete(t);
    }

    @Override
    public void update(T t) {
        repository.save(t);
    }

    @Override
    public T findById(ID id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
}
