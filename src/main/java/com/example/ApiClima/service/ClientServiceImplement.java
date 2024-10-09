package com.example.ApiClima.service;

import com.example.ApiClima.dtos.ClientDTO;
import com.example.ApiClima.models.Client;
import com.example.ApiClima.repositories.ClientRepository;
import io.jsonwebtoken.security.Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class ClientServiceImplement implements ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean existsByEmail(String email){
        return clientRepository.existsByEmail(email);
    }

    @Override
    public void saveClient(Client client){
        clientRepository.save(client);
    }

    @Override
    public ResponseEntity<String> registerClient(ClientDTO clientDTO) {

        if (clientDTO.getName().isBlank()) {
            return new ResponseEntity<>("Name can't be blank", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getLast_name().isBlank()) {
            return new ResponseEntity<>("LastName can't be blank", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getEmail().isBlank()) {
            return new ResponseEntity<>("Email can't be blank", HttpStatus.FORBIDDEN);
        }
        if (clientDTO.getPassword().isBlank()) {
            return new ResponseEntity<>("Password can't be blank", HttpStatus.FORBIDDEN);
        }
        if (existsByEmail(clientDTO.getEmail())) {
            return new ResponseEntity<>("Email already on use", HttpStatus.FORBIDDEN);
        }

        Client client = new Client(clientDTO.getName(),
                clientDTO.getLast_name(),
                clientDTO.getEmail(),
                passwordEncoder.encode(clientDTO.getPassword()));
        saveClient(client);


        return new ResponseEntity<>("Client created", HttpStatus.CREATED);
    }

}
