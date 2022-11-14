package org.webp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

//By sınıf ayni isimdeki bir veritabani tablosunu maplemektedir.
@Entity
public class UserDetails {

    @OneToOne
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;

    @Pattern(regexp = "[0-9\\s]{12}")
    private String phone;


    public UserDetails() {
    }


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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}