package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client addClient(Client client) {
        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        clientRepository.deleteById(id);
    }

    public Client findById(Long id) {
        Optional<Client> response = clientRepository.findById(id);
        if(response.isPresent())
            return response.get();
        return null;
    }


    @Transactional
    public void updateClient(Long id, Client client) throws IllegalStateException {
        Client client1 = this.findById(id);
       if (client1.getFullName().equals(client)){
           client1.setFullName(client1.getFullName());
       }
        if (client1.getIncome().equals(client)){
            client1.setIncome(client1.getIncome());
        }
        clientRepository.save(client1);
    }

}
