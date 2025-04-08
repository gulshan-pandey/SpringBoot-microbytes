package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Cache;

import java.io.Serializable;



@Entity
@Table(name = "users2")
@Data
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "userEntityCache")
public class TestEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


}
