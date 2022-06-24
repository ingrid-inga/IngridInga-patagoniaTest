package com.example.patagoniatest.service;

import com.example.patagoniatest.model.Client;
import com.example.patagoniatest.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock

    private MockMvc mockMvc;
    private ClientRepository clientRepository;
    private ClientService serviceUnderTest;

    @BeforeEach
    void setUp() { serviceUnderTest = new ClientService(clientRepository);}

    @Test
    void getClients() {
        serviceUnderTest.getClients();
        verify(clientRepository).findAll();
    }

    @Test
    void addClient() {
        Client client = new Client(
                111L,
                "Esteban Dido",
                123123
        );

        serviceUnderTest.addClient(client);

        ArgumentCaptor<Client> clientArgumentCaptor = ArgumentCaptor.forClass(Client.class);
        verify(clientRepository).save(clientArgumentCaptor.capture());

        Client capturedClient = clientArgumentCaptor.getValue();

        assertThat(capturedClient).isEqualTo(client);
    }


    @Test
    //@Disabled
    void deleteClient() throws Exception {
        Mockito.when(clientRepository.findById(111L)).thenReturn(Optional.of(null));

        mockMvc.perform(MockMvcRequestBuilders.
                delete("/clients/deleteClient/{id}").
                contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    @Disabled
    void getClientById() {



    }

    @Test
    @Disabled
    void updateClient() {
    }
}