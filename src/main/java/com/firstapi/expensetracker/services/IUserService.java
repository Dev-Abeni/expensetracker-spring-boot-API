package com.firstapi.expensetracker.services;

import com.firstapi.expensetracker.domain.User;
import com.firstapi.expensetracker.exceptions.EtAuthException;

public interface IUserService {
    User validateUser(String email, String password) throws EtAuthException;
    User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException;

}
