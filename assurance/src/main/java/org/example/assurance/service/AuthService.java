package org.example.assurance.service;

import org.example.assurance.model.Utilisateur;

public interface AuthService {
    void register(Utilisateur utilisateur);
    Utilisateur login(String email, String password);
}
