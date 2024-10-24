package org.example.assurance.dao;

import org.example.assurance.model.Contrat;

import java.util.List;

public interface ContratDao {
    void save(Contrat contrat);
    void edit(Contrat contrat);
    Contrat findById(Long id);
    List<Contrat> findAll();
}
