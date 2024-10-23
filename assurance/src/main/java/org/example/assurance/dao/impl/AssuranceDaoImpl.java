package org.example.assurance.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.assurance.dao.AssuranceDao;
import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AssuranceDaoImpl implements AssuranceDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveHabitation(Habitation habitation) {
        entityManager.persist(habitation);
    }

    @Override
    public void saveAutomobile(Automobile automobile) {
        entityManager.persist(automobile);
    }
}
