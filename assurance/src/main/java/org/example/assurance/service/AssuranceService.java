package org.example.assurance.service;

import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;

public interface AssuranceService {
    void saveHabitation(Habitation habitation);

    void saveAutomobile(Automobile automobile);
}
