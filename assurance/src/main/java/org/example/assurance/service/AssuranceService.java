package org.example.assurance.service;

import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;

public interface AssuranceService {
    void saveHabitation(Habitation habitation);

    void saveAutomobile(Automobile automobile);

    void saveSante(Sante sante);
}
