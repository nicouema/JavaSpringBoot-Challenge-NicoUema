package com.alkemy.disneyAPI.securityweb;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @Column(unique = true, nullable = false)
    private Integer id;

    private String name;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
