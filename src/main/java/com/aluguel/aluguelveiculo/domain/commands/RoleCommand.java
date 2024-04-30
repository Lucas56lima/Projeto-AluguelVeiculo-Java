package com.aluguel.aluguelveiculo.domain.commands;

public class RoleCommand {
    
    private Long roleId;    
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getRoleId() {
        return roleId;
    }
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public enum Values{
        ADMIN(1),
        BASIC(2);

        long roleId;        

        Values(long roleId){
            this.roleId = roleId;
        }

        public long getRoleId() {
            return roleId;
        }

    }
    
}
