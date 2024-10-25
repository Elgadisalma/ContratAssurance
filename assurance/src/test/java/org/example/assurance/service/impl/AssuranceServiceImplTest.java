package org.example.assurance.service.impl;

import org.example.assurance.dao.AssuranceDao;
import org.example.assurance.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AssuranceServiceImplTest {

    @Mock
    private AssuranceDao assuranceDao;

    @InjectMocks
    private AssuranceServiceImpl assuranceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void devisSante() {
        Sante sante = new Sante();
        sante.setAge(65);
        sante.setEtatSante("maladie chronique");
        sante.setTypeCouverture(TypeCouverture.BASIC);

        Double montant = assuranceService.devisSante(sante);

        assertEquals(280.8, montant, 0.01);
    }

    @Test
    void devisHabitation() {
        Habitation habitation = new Habitation();
        habitation.setTypeLogement(TypeLogement.MAISON);
        habitation.setRisque(true);
        habitation.setValeurBien(250_000);
        habitation.setSystemSecurite(false);

        Double montant = assuranceService.devisHabitation(habitation);

        assertEquals(406.4445, montant, 0.01);
    }

    @Test
    void devisAutomobile() {
        Automobile automobile = new Automobile();
        automobile.setAge(22);
        automobile.setTypeVehicule(TypeVehicule.LUXE);
        automobile.setUtilisationVehicule(UtilisationVehicule.PROFESSIONNEL);
        automobile.setHistorique("sinistre");

        Double montant = assuranceService.devisAutomobile(automobile);

        assertEquals(765.325, montant, 0.01);
    }

    @Test
    void findSanteById() {
        Sante sante = new Sante();
        sante.setId(1L);
        when(assuranceDao.findById(1L, Sante.class)).thenReturn(java.util.Optional.of(sante));

        Sante result = assuranceService.findSanteById(1L);

        assertEquals(sante, result);
        verify(assuranceDao, times(1)).findById(1L, Sante.class);
    }

    @Test
    void findHabitationById() {
        Habitation habitation = new Habitation();
        habitation.setId(1L);
        when(assuranceDao.findById(1L, Habitation.class)).thenReturn(java.util.Optional.of(habitation));

        Habitation result = assuranceService.findHabitationById(1L);

        assertEquals(habitation, result);
        verify(assuranceDao, times(1)).findById(1L, Habitation.class);
    }

    @Test
    void findAutomobileById() {
        Automobile automobile = new Automobile();
        automobile.setId(1L);
        when(assuranceDao.findById(1L, Automobile.class)).thenReturn(java.util.Optional.of(automobile));

        Automobile result = assuranceService.findAutomobileById(1L);

        assertEquals(automobile, result);
        verify(assuranceDao, times(1)).findById(1L, Automobile.class);
    }
}
