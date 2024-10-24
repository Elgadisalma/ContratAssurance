package org.example.assurance.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.assurance.dao.ContratDao;
import org.example.assurance.model.Contrat;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ContratDaoImpl implements ContratDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void save(Contrat contrat) {
        entityManager.persist(contrat);
    }

    @Override
    public void edit(Contrat contrat) {
        entityManager.merge(contrat);
    }

    @Override
    public Contrat findById(Long id) {
        return entityManager.find(Contrat.class, id);
    }

    @Override
    public List<Contrat> findByUserId(Long userId) {
        String query = "SELECT c FROM Contrat c JOIN Assurance a ON c.assuranceId = a.id WHERE a.userId = :userId";
        return entityManager.createQuery(query, Contrat.class)
                .setParameter("userId", userId)
                .getResultList();

    }
}
