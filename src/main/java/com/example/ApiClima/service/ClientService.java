package com.example.ApiClima.service;

import com.example.ApiClima.dtos.ClientDTO;
import com.example.ApiClima.models.Client;
import org.springframework.http.ResponseEntity;

public interface ClientService {
    boolean existsByEmail(String email);
    void saveClient(Client client);
    ResponseEntity<String> registerClient(ClientDTO clientDTO);
}