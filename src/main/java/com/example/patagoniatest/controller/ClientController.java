package com.example.patagoniatest.controller;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Optional<Client> getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping("/deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/update/{id}")
    public void updateClient(@PathVariable("id") Long id, @RequestBody Client client){
         clientService.updateClient(client, id);
    }

    @GetMapping("/getEarningsAverage")
    public OptionalDouble getEarningsAverage(){
        return clientService.getEarningsAverage();
    }

    @GetMapping("/getNames")
    public String getNames(){
        return clientService.getNames();
    }

    @GetMapping("/getTopEarners")
    public List<Client> getTopEarners(){
        return clientService.getTopEarners();
    }

  /*  @GetMapping("/incomeprom")
    public Optional getIncomeprom(@PathVariable Integer income){
        return clientService.getIncomeprom(incomeprom);
    }


    @GetMapping("/income")
    public Optional getIncome(@PathVariable Integer income){
        return clientService.getIncome(income);
    }*/


}
