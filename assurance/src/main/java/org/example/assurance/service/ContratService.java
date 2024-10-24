package org.example.assurance.service;

import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;

public interface ContratService {
    void saveContrat(Contrat contrat);
    void saveDocument(Document document);
}
