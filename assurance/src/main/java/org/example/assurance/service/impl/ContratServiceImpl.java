package org.example.assurance.service.impl;

import org.example.assurance.dao.ContratDao;
import org.example.assurance.dao.DocumentDao;
import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;
import org.example.assurance.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContratServiceImpl implements ContratService {
    @Autowired
    private ContratDao contratDao;

    @Autowired
    private DocumentDao documentDao;


    @Override
    public void saveContrat(Contrat contrat) {
        contratDao.save(contrat);
    }

    @Override
    public void saveDocument(Document document) {
        documentDao.save(document);
    }
}
