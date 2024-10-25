package org.example.assurance.service.impl;

import org.example.assurance.dao.ContratDao;
import org.example.assurance.dao.DocumentDao;
import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ContratServiceImplTest {

    @Mock
    private ContratDao contratDao;

    @Mock
    private DocumentDao documentDao;

    @InjectMocks
    private ContratServiceImpl contratService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void saveContrat() {
        Contrat contrat = new Contrat();
        contrat.setId(1L);

        contratService.saveContrat(contrat);

        verify(contratDao, times(1)).save(contrat);
    }

    @Test
    void editContrat() {
        Contrat contrat = new Contrat();
        contrat.setId(1L);

        contratService.editContrat(contrat);

        verify(contratDao, times(1)).edit(contrat);
    }

    @Test
    void findById() {
        Long id = 1L;
        Contrat contrat = new Contrat();
        contrat.setId(id);

        when(contratDao.findById(id)).thenReturn(contrat);

        Contrat result = contratService.findById(id);

        assertNotNull(result);
        assertEquals(id, result.getId());
    }

    @Test
    void findContratsByUserId() {
        Long userId = 1L;
        List<Contrat> contrats = new ArrayList<>();
        contrats.add(new Contrat());
        contrats.add(new Contrat());

        when(contratDao.findByUserId(userId)).thenReturn(contrats);

        List<Contrat> result = contratService.findContratsByUserId(userId);

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}
