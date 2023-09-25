package br.com.claro.client.util;

import br.com.claro.client.entity.Client;

import java.time.LocalDate;

public class ClientCreator {

    public static Client createClientToBeSaved(){
        return Client.builder()
                .name("Joaquim Cruz")
                .cpf("888.777.666-55")
                .email("joaquim.cruz@example.com")
                .birthDate(LocalDate.now())
                .build();
    }

    public static Client createValidClient(){
        return Client.builder()
                .name("Carine Malta")
                .id(1L)
                .build();
    }

    public static Client createValidUpdatedClient(){
        return Client.builder()
                .name("Carine Malta 2")
                .id(1L)
                .build();
    }
}
