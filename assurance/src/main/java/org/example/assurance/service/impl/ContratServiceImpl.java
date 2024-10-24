package org.example.assurance.service.impl;

import org.example.assurance.dao.ContratDao;
import org.example.assurance.dao.DocumentDao;
import org.example.assurance.model.Contrat;
import org.example.assurance.model.Document;
import org.example.assurance.service.ContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    @Override
    public void editContrat(Contrat contrat) {
        contratDao.edit(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return contratDao.findById(id);
    }

    @Override
    public List<Contrat> findAllContrats() {
        return contratDao.findAll(); // Utilisez la méthode findAll du DAO
    }
}
