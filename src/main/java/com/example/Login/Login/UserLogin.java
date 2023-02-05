package com.example.Login.Login;

import com.example.Login.Register.User;

import javax.persistence.*;

@Entity
public class UserLogin {
    @Id
    @SequenceGenerator(
            name = "user_login_sequence",
            sequenceName = "user_login_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_login_sequence"
    )
    private Long id;
    private String email;
    private String passwordHash;
    private String passwordSalt;
    @OneToOne
    private User user;

    public UserLogin() {
    }

    public UserLogin(String email, String passwordHash, String passwordSalt, User user) {
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.user = user;
    }

    public UserLogin(Long id, String email, String passwordHash, String passwordSalt, User user) {
        this.id = id;
        this.email = email;
        this.passwordHash = passwordHash;
        this.passwordSalt = passwordSalt;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
