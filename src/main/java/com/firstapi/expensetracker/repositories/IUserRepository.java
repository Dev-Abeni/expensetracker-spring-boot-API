package com.firstapi.expensetracker.repositories;

import com.firstapi.expensetracker.domain.User;
import com.firstapi.expensetracker.exceptions.EtAuthException;
import org.springframework.stereotype.Repository;

public interface IUserRepository {
    Integer create(String firstName, String lastName, String email, String password) throws EtAuthException;
    User findByEmailAndPassword(String email, String password) throws EtAuthException;
    Integer getCountByEmail(String email);
    User findById(Integer userId);
}
