package com.example.ApiClima.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class QueryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Client client;
    private String query;
    private String response;

    public QueryLog() {
    }

    public QueryLog(Client client, String query, String response) {
        this.client = client;
        this.query = query;
        this.response = response;
    }
}

