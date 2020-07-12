package com.mentor.link.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = DbConstants.Tables.TABLE_USERS_FILTER)
public class UserSearchFilter {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @Column(name = "city", nullable = false, length = 200)
    private String city;

    @Column(name = "country", nullable = false, length = 200)
    private String country;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
