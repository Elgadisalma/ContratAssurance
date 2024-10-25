package org.example.assurance.service.impl;

import org.example.assurance.dao.UserDao;
import org.example.assurance.model.Utilisateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthServiceImplTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private AuthServiceIml authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void register() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("test@example.com");
        utilisateur.setPassword("password");

        authService.register(utilisateur);

        verify(userDao, times(1)).save(utilisateur);
    }

    @Test
    void login_Success() {
        String email = "test@example.com";
        String password = "password";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(email);
        utilisateur.setPassword(password);

        when(userDao.findByEmail(email)).thenReturn(utilisateur);

        Utilisateur result = authService.login(email, password);

        assertNotNull(result);
        assertEquals(email, result.getEmail());
        assertEquals(password, result.getPassword());
    }

    @Test
    void login_Failure_WrongPassword() {
        String email = "test@example.com";
        String password = "wrongpassword";
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(email);
        utilisateur.setPassword("correctpassword");

        when(userDao.findByEmail(email)).thenReturn(utilisateur);

        Utilisateur result = authService.login(email, password);

        assertNull(result);
    }

    @Test
    void login_Failure_UserNotFound() {
        String email = "unknown@example.com";
        String password = "password";

        when(userDao.findByEmail(email)).thenReturn(null);

        Utilisateur result = authService.login(email, password);

        assertNull(result);
    }
}
