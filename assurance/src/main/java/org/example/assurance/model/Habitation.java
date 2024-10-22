package org.example.assurance.model;

import jakarta.persistence.*;

@Entity
public class Habitation extends Contrat {
    private double valeurBien;

    @Enumerated(EnumType.STRING)
    private TypeLogement typeLogement;

    private boolean risque;

    private boolean systemSecurite;

    public Habitation() {}

    public double getValeurBien() {
        return valeurBien;
    }

    public void setValeurBien(double valeurBien) {
        this.valeurBien = valeurBien;
    }

    public TypeLogement getTypeLogement() {
        return typeLogement;
    }

    public void setTypeLogement(TypeLogement typeLogement) {
        this.typeLogement = typeLogement;
    }

    public boolean isRisque() {
        return risque;
    }

    public void setRisque(boolean risque) {
        this.risque = risque;
    }

    public boolean isSystemSecurite() {
        return systemSecurite;
    }

    public void setSystemSecurite(boolean systemSecurite) {
        this.systemSecurite = systemSecurite;
    }
}
