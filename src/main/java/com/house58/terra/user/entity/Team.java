package com.house58.terra.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.house58.terra.schedule.entity.SShedule;
import com.house58.terra.therapy.entity.Therapy;
import com.house58.terra.user.enumm.BillingEnum;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.*;

@Entity(name = "therapist")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Team extends User{
    //public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "document", unique = true, nullable = false)
    private String cpf;
    @Column(name = "username", unique = true, nullable = false)
    private String username;
    private String employDocument;
    private String phoneNumber;
    private Date birthDay;
    private String organizationSocial;
    private BillingEnum billingMode;
    private String professionalRegistration;

    @ManyToMany
    @JoinTable(
            name = "team_therapies",
            joinColumns = @JoinColumn(name = "team_id"),
            inverseJoinColumns = @JoinColumn(name = "therapy_id")
    )
    private Set<Therapy> therapies;

    @OneToMany
    private List<SShedule> shedules;


    private BillingEnum contractType;
    private Number percentage;
    private BigDecimal remuneration;
    private String session;
    private Boolean active;

    @Transient
    private List<String> sessionsId;

    public Team(){

    }

    public Team(Team team) {
        super();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmployDocument() {
        return employDocument;
    }

    public void setEmployDocument(String employDocument) {
        this.employDocument = employDocument;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getOrganizationSocial() {
        return organizationSocial;
    }

    public void setOrganizationSocial(String organizationSocial) {
        this.organizationSocial = organizationSocial;
    }

    public String getProfessionalRegistration() {
        return professionalRegistration;
    }

    public void setProfessionalRegistration(String professionalRegistration) {
        this.professionalRegistration = professionalRegistration;
    }

    public Set<Therapy> getTherapies() {
        return therapies;
    }

    public void setTherapies(Set<Therapy> therapies) {
        this.therapies = therapies;
    }

    public Set<Therapy> getDiscipline() {
        return therapies;
    }

    public void setDiscipline(List<Therapy> discipline) {

        this.therapies = therapies;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public BillingEnum getBillingMode() {
        return billingMode;
    }

    public void setBillingMode(BillingEnum billingMode) {
        this.billingMode = billingMode;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<SShedule> getShedules() {
        return shedules;
    }

    public void setShedules(List<SShedule> shedules) {
        this.shedules = shedules;
    }

    public List<String> getSessionsId() {
        return sessionsId;
    }

    public void setSessionsId(List<String> sessionsId) {
        this.sessionsId = sessionsId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BillingEnum getContractType() {
        return contractType;
    }

    public void setContractType(BillingEnum contractType) {
        this.contractType = contractType;
    }

    public Number getPercentage() {
        return percentage;
    }

    public void setPercentage(Number percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getRemuneration() {
        return remuneration;
    }

    public void setRemuneration(BigDecimal remuneration) {
        this.remuneration = remuneration;
    }

    public void addTherapy(Therapy therapy){
        this.therapies.add(therapy);
        therapy.getTeams().add(this);
    }
    public void removeTherapy(Therapy therapy){
        this.therapies.remove(therapy);
        therapy.getTeams().remove(this);
    }


}
