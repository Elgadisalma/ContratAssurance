package org.example.assurance.service;

import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;

public interface AssuranceService {
    void saveHabitation(Habitation habitation);
    void saveAutomobile(Automobile automobile);
    void saveSante(Sante sante);
    Double devisSante(Sante sante);
    Double devisHabitation(Habitation habitation);
    Double devisAutomobile(Automobile automobile);

    Sante findSanteById(Long santeId);
    Habitation findHabitationById(Long id);
    Automobile findAutomobileById(Long id);
}
