package org.example.assurance.service.impl;

import org.example.assurance.dao.AssuranceDao;
import org.example.assurance.model.Automobile;
import org.example.assurance.model.Habitation;
import org.example.assurance.model.Sante;
import org.example.assurance.service.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssuranceServiceImpl implements AssuranceService {

    @Autowired
    private AssuranceDao assuranceDao;

    @Override
    public void saveHabitation(Habitation habitation) {
        assuranceDao.saveHabitation(habitation);
    }

    @Override
    public void saveAutomobile(Automobile automobile) {
        assuranceDao.saveAutomobile(automobile);
    }

    @Override
    public void saveSante(Sante sante) {
        assuranceDao.saveSante(sante);
    }
}
