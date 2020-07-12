package com.mentor.link.persistence.model;

import javax.persistence.*;

@Entity
@Table(name = DbConstants.Tables.USERS)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "email", unique = true, nullable = false, length = 200)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "city", nullable = false, length = 200)
    private String city;

    @Column(name = "country", nullable = false, length = 200)
    private String country;

    @Column(name = "gender", nullable = false)
    private Gender gender;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private UserSearchFilter userSearchFilter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public UserSearchFilter getUserSearchFilter() {
        return userSearchFilter;
    }

    public void setUserSearchFilter(UserSearchFilter userSearchFilter) {
        this.userSearchFilter = userSearchFilter;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
