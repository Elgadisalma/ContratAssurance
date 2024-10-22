package org.example.assurance.dao;

import org.example.assurance.model.Utilisateur;

public interface UserDao {

    void save(Utilisateur utilisateur);
    Utilisateur findByEmail(String email);

}
