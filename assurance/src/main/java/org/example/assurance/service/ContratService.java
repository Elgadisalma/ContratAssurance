package org.example.assurance.service;

import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;

import java.util.List;

public interface ContratService {
    void saveContrat(Contrat contrat);
    void saveDocument(Document document);
    Contrat findById(Long contratId);
    void editContrat(Contrat contrat);
    List<Contrat> findAllContrats(); // Nouvelle méthode
}
