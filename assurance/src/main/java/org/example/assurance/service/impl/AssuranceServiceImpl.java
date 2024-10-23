package org.example.assurance.service.impl;

import org.example.assurance.dao.AssuranceDao;
import org.example.assurance.model.*;
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

    @Override
    public Double devisSante(Sante sante) {
        double montant = 200;
        if (sante.getAge() > 60) {
            montant += montant * 0.2;
        }
        if (sante.getEtatSante().contains("maladie chronique")) {
            montant += montant * 0.3;
        }
        if (sante.getTypeCouverture() == TypeCouverture.BASIC) {
            montant -= montant * 0.1;
        } else if (sante.getTypeCouverture() == TypeCouverture.PREMIUM) {
            montant += montant * 0.05;
        }
        return montant;
    }

    @Override
    public Double devisHabitation(Habitation habitation) {
        double montant = 300;
        if (habitation.getTypeLogement() == TypeLogement.MAISON) {
            montant += montant * 0.02;
        }
        if (habitation.isRisque()) {
            montant += montant * 0.05; //zone rique
        }
        if (habitation.getValeurBien() > 200_000) {
            montant += montant * 0.1; // +10% si la valeur du bien plus que 200 000 dh
        }
        if (habitation.isSystemSecurite()) {
            montant -= montant * 0.15; // systeme de securite
        } else {
            montant += montant * 0.15; // +15% sinon
        }
        return montant;
    }

    @Override
    public Double devisAutomobile(Automobile automobile) {
        double montant = 500;
        if (automobile.getAge() < 25) {
            montant += montant * 0.1;
        }

        if (automobile.getTypeVehicule() == TypeVehicule.LUXE) {
            montant += montant * 0.15;
        }

        if (automobile.getUtilisationVehicule() == UtilisationVehicule.PROFESSIONNEL) {
            montant += montant * 0.1;
        }

        if (automobile.getHistorique() != null && automobile.getHistorique().contains("sinistre")) {
            montant += montant * 0.1;
        } else {
            montant -= montant * 0.2;
        }

        return montant;
    }


    @Override
    public Sante findSanteById(Long id) {
        return assuranceDao.findById(id, Sante.class).orElse(null);
    }

    @Override
    public Habitation findHabitationById(Long id) {
        return assuranceDao.findById(id, Habitation.class).orElse(null);
    }

    @Override
    public Automobile findAutomobileById(Long id) {
        return assuranceDao.findById(id, Automobile.class).orElse(null);
    }

}
