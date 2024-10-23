package org.example.assurance.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.assurance.dao.AssuranceDao;
import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public class AssuranceDaoImpl implements AssuranceDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveHabitation(Habitation habitation) {
        if (habitation.getId() != null && findById(habitation.getId(), Habitation.class).isPresent()) {
            entityManager.merge(habitation);
        } else {
            entityManager.persist(habitation);
        }
    }

    @Override
    public void saveAutomobile(Automobile automobile) {
        if (automobile.getId() != null && findById(automobile.getId(), Automobile.class).isPresent()) {
            entityManager.merge(automobile);
        } else {
            entityManager.persist(automobile);
        }
    }

    @Override
    public void saveSante(Sante sante) {
        if (sante.getId() != null && findById(sante.getId(), Sante.class).isPresent()) {
            entityManager.merge(sante);
        } else {
            entityManager.persist(sante);
        }
    }


    @Override
    public <T> Optional<T> findById(Long id, Class<T> type) {
        T entity = entityManager.find(type, id);
        return Optional.ofNullable(entity);
    }

}
