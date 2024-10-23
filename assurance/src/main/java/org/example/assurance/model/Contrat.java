package org.example.assurance.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    @Temporal(TemporalType.DATE)
    private Date dateFin;


    private double montant;

    @Column(name = "assurance_id")
    private Long assuranceId;

    private boolean resilier;

    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    private List<Document> documents;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }


    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Long getAssuranceId() {
        return assuranceId;
    }

    public void setAssuranceId(Long assuranceId) {
        this.assuranceId = assuranceId;
    }

    public boolean isResilier() {
        return resilier;
    }

    public void setResilier(boolean resilier) {
        this.resilier = resilier;
    }


    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}