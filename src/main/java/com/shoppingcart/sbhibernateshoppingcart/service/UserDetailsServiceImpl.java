package com.shoppingcart.sbhibernateshoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    private AccountDAO accountDAO;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Account account = accountDAO.findAccount(username);
//        System.out.println("Account= " + account);
//
//        if (account == null) {
//            throw new UsernameNotFoundException("User " + username + "was not found in the database");
//        }
//
//        //EMPLOYEE, MANAGER...
//        String role = account.getUserRole();
//    }
//
//}
