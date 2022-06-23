package com.firstapi.expensetracker.services;

import com.firstapi.expensetracker.domain.Category;
import com.firstapi.expensetracker.exceptions.EtBadRequestException;
import com.firstapi.expensetracker.exceptions.EtResourceNotFoundException;

import java.util.List;


public interface ICategoryService {
    List<Category> fetchAllCategories(Integer userId);
    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
    Category addCategory(Integer userId, String title, String description) throws EtBadRequestException;
    void updateCategory(Integer userId, Integer categoryId, Category category) throws EtBadRequestException;
    void removeCategoryWithAllTransactions(Integer userId, Integer catergoryId) throws EtResourceNotFoundException;
}
