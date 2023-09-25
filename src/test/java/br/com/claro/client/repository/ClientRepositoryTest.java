package br.com.claro.client.repository;

import br.com.claro.client.entity.Client;
import br.com.claro.client.util.ClientCreator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static br.com.claro.client.entity.Client.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Tests for Client Repository")
class ClientRepositoryTest {
    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Save creates a client when successful")
    void save_PersistClient_WhenSuccessful(){
        Client clientToBeSaved = ClientCreator.createClientToBeSaved();
        Client savedClient = this.clientRepository.save(clientToBeSaved);

        Assertions.assertThat(savedClient).isNotNull();
        Assertions.assertThat(savedClient.getId()).isNotNull();
        Assertions.assertThat(savedClient.getName()).isEqualTo(clientToBeSaved.getName());
    }

    @Test
    @DisplayName("Save updates client when Successful")
    void save_UpdatesClient_WhenSuccessful(){
        Client clientToBeSaved = ClientCreator.createClientToBeSaved();

        Client savedClient = this.clientRepository.save(clientToBeSaved);

        savedClient.setName("Jose");

        Client updatedClient = this.clientRepository.save(savedClient);

        Assertions.assertThat(savedClient).isNotNull();

        Assertions.assertThat(savedClient.getId()).isNotNull();

        Assertions.assertThat(savedClient.getName()).isEqualTo(clientToBeSaved.getName());
    }

    @Test
    @DisplayName("Delete removes client when Successful")
    void delete_RemovesClient_WhenSuccessful(){
        Client clientToBeSaved = ClientCreator.createClientToBeSaved();

        Client savedClient = this.clientRepository.save(clientToBeSaved);

        this.clientRepository.delete(savedClient);
        Optional<Client> clientOptional = this.clientRepository.findById(savedClient.getId());

        Assertions.assertThat(clientOptional).isEmpty();

    }

    @Test
    @DisplayName("FindByID returns the exactly client when Successful")
    void findById_ReturnsClient_WhenSuccessful(){
        Client clientToBeSaved = ClientCreator.createClientToBeSaved();

        Client savedClient = this.clientRepository.save(clientToBeSaved);

        Optional<Client> returnedClient = this.clientRepository.findById(savedClient.getId());

        Assertions.assertThat(returnedClient.get().getId()).isEqualTo(savedClient.getId());

    }

    @Test
    @DisplayName("FindByID returns empty client when no Client is Found")
    void findById_ReturnsEmptyList_WhenNoClientWasFound(){

        List<Client> clientList = clientRepository.findAll();

        Assertions.assertThat(clientList).isEmpty();

    }

}