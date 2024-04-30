package com.aluguel.aluguelveiculo.domain.commands;

import java.util.Set;

import com.aluguel.aluguelveiculo.domain.entities.Role;

public class UserAdminCommand {
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
