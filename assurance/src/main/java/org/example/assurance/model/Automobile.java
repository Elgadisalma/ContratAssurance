package org.example.assurance.model;

import jakarta.persistence.*;

@Entity
public class Automobile extends Contrat {
    private int age;

    @Enumerated(EnumType.STRING)
    private TypeVehicule typeVehicule;

    @Enumerated(EnumType.STRING)
    private UtilisationVehicule utilisationVehicule;

    private String historique;

    public Automobile() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TypeVehicule getTypeVehicule() {
        return typeVehicule;
    }

    public void setTypeVehicule(TypeVehicule typeVehicule) {
        this.typeVehicule = typeVehicule;
    }

    public UtilisationVehicule getUtilisationVehicule() {
        return utilisationVehicule;
    }

    public void setUtilisationVehicule(UtilisationVehicule utilisationVehicule) {
        this.utilisationVehicule = utilisationVehicule;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }
}
