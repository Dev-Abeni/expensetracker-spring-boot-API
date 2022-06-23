package com.firstapi.expensetracker.repositories;

import com.firstapi.expensetracker.domain.Category;
import com.firstapi.expensetracker.exceptions.EtBadRequestException;
import com.firstapi.expensetracker.exceptions.EtResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository {
    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;
    Category findById(Integer userId, Integer categoryId) throws  EtResourceNotFoundException;
    Integer create(Integer userId, String title, String description) throws EtBadRequestException;
    void update(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
    void removeById(Integer userId, Integer categoryId);
}
