package org.example.assurance.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.example.assurance.dao.DocumentDao;
import org.example.assurance.model.Document;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class DocumentDaoImpl implements DocumentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Document document) {
        entityManager.persist(document);
    }
}
