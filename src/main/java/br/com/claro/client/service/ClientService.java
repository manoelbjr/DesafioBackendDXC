package br.com.claro.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.claro.client.entity.Client;
import br.com.claro.client.repository.ClientRepository;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Validated
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> list(){
        return clientRepository.findAll();
    }

    public Optional<Client> findById(Long id){
        return clientRepository.findById(id);
    }

    public Client create(Client client){
        return clientRepository.save(client);
    }

    public Optional<Client> update(Long id, Client client){
        return clientRepository.findById(id)
                .map(clientFound -> {
                    clientFound.setCpf(client.getCpf());
                    clientFound.setName(client.getName());
                    clientFound.setEmail(client.getEmail());
                    clientFound.setBirthDate(client.getBirthDate());
                    return clientRepository.save(clientFound);
                });
    }

    public boolean delete(Long id){
        return clientRepository.findById(id)
                .map(clientFound ->{
                    clientRepository.deleteById(id);
                    return true;
                }).orElse(false);
    }
}
