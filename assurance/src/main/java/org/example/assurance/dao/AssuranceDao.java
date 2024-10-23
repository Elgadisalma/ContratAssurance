package org.example.assurance.dao;

import org.example.assurance.model.Habitation;
import org.springframework.stereotype.Repository;

public interface AssuranceDao {
    void save(Habitation habitation);
}
