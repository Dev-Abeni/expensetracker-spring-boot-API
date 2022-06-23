package com.firstapi.expensetracker.services;

import com.firstapi.expensetracker.domain.User;
import com.firstapi.expensetracker.exceptions.EtAuthException;
import com.firstapi.expensetracker.repositories.IUserRepository;
import com.firstapi.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Spring @Service annotation is used with classes that provide
 * some business functionalities. Spring context will autodetect
 * these classes when annotation-based configuration and classpath
 * scanning is used.
 * */
@Service

/**
 * The @Transactional annotation makes use of the attributes
 * rollbackFor or rollbackForClassName to roll-back the transactions.
 * The default rollback behavior in the declarative approach will
 * rollback on runtime exceptions.
 * */
@Transactional
public class UserService implements IUserService{

    /**
     * The Spring framework enables automatic dependency injection.
     * In other words, by declaring all the bean dependencies in a
     * Spring configuration file, Spring container can autowire
     * relationships between collaborating beans. This is called Spring
     * bean autowiring.
     * */
    @Autowired
    IUserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws EtAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String firstName, String lastName, String email, String password) throws EtAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");

        if(email != null) email = email.toLowerCase();

        if(!pattern.matcher(email).matches())
                throw new EtAuthException("Invalid email format");

        Integer count = userRepository.getCountByEmail(email);

        if(count > 0)
                throw new EtAuthException("Email already in use");

        Integer userId = userRepository.create(firstName, lastName, email, password);
        return userRepository.findById(userId);
    }
}
