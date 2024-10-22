package org.example.assurance.service.impl;

import org.example.assurance.dao.UserDao;
import org.example.assurance.model.Utilisateur;
import org.example.assurance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceIml implements AuthService {

    @Autowired
    private UserDao userDao;


    @Override
    public void register(Utilisateur utilisateur) {
//        System.out.println("salma");
        userDao.save(utilisateur);
    }

    @Override
    public Utilisateur login(String email, String password) {
        Utilisateur utilisateur = userDao.findByEmail(email);

        if (utilisateur != null && utilisateur.getPassword().equals(password)) {
            return utilisateur;
        }

        return null;
    }
}
