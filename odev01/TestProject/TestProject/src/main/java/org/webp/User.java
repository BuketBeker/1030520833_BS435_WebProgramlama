package org.webp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    private Long id;

    @OneToOne(mappedBy = "id")
    private Long userid;
    @NotBlank
    private String username;
    @NotBlank
    private String password;


    public User(){}


    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long id) { this.userid = userid; }

}

