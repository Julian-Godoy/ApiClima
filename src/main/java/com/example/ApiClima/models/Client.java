package com.example.ApiClima.models;

import com.example.ApiClima.models.enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name, last_name, email, password;
    private Roles rol = Roles.CLIENT;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<QueryLog> queries = new ArrayList<>();


    public Client() {
    }

    public Client(long id, String name, String last_name, String email, String password) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
    }
}
