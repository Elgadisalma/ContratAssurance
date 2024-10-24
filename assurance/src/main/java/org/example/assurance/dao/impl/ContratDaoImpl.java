package org.example.assurance.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.assurance.dao.ContratDao;
import org.example.assurance.model.Contrat;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ContratDaoImpl implements ContratDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Contrat contrat) {
        entityManager.persist(contrat);
    }
}
