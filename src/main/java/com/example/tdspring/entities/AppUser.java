package com.example.tdspring.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.sun.istack.internal.NotNull;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String password;

    @NotNull
    private String username;

    @ManyToMany(fetch= FetchType.EAGER)
    private Collection<AppRole> roles =new ArrayList<>();

    public AppUser() {
    }

    public AppUser(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public AppUser(String password, String username, Collection<AppRole> roles) {
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) {
        this.roles = roles;
    }
}
