package org.example.assurance.dao;

import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface AssuranceDao {
    void saveHabitation(Habitation habitation);
    void saveAutomobile(Automobile automobile);
    void saveSante(Sante sante);
    <T> Optional<T> findById(Long id, Class<T> type);
}
