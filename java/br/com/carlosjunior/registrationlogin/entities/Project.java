package br.com.carlosjunior.registrationlogin.entities;

import javax.persistence.*;

@Entity
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "budget")
    private String budget;

    @Column(name = "duration")
    private String duration;

    @Column(name = "scope")
    private String scope;
    
    @ManyToOne
    @JoinColumn(name = "cont_id")
    private Contractor contractor;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }


    public Contractor getContractor() {
        return contractor;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor;
    }

    // toString method

    @Override
    public String toString() {
        return "Project [id=" + id + ", budget=" + budget + ", duration=" + duration + ", scope=" + scope + "]";
    }
}
