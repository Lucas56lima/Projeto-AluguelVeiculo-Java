package com.aluguel.aluguelveiculo.domain.entities;

import java.util.Set;

public class UserAdmin {
    private String username;
    private String password;
    private Set<Role> roles;
    
    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
