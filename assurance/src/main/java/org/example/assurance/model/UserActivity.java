package org.example.assurance.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_activity")
public class UserActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity", nullable = false)
    private String activity;

    @Column(name = "user_id")
    private Long userId;

    public UserActivity(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivity(){
        return activity;
    }
    public void setActivity(){
        this.activity = activity;
    }

    public Long getUserId(){
        return userId;
    }
    public void setUserId(){
        this.userId = userId;
    }
}
