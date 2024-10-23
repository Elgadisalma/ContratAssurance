package org.example.assurance.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Assurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeAssurance typeAssurance;


    @Column(name = "user_id")
    private Long userId;

    private boolean accepte = false;

    public Assurance() {}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeAssurance getTypeAssurance() {
        return typeAssurance;
    }

    public void setTypeAssurance(TypeAssurance typeAssurance) {
        this.typeAssurance = typeAssurance;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isAccepte() {
        return accepte;
    }

    public void setAccepte(boolean accepte) {
        this.accepte = accepte;
    }


}
