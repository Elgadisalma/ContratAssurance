package org.example.assurance.model;

import jakarta.persistence.*;

@Entity
public class Sante extends Devis {
    private int age;

    private String etatSante;

    @Enumerated(EnumType.STRING)
    private TypeCouverture typeCouverture;

    public Sante() {}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEtatSante() {
        return etatSante;
    }

    public void setEtatSante(String etatSante) {
        this.etatSante = etatSante;
    }

    public TypeCouverture getTypeCouverture() {
        return typeCouverture;
    }

    public void setTypeCouverture(TypeCouverture typeCouverture) {
        this.typeCouverture = typeCouverture;
    }
}
