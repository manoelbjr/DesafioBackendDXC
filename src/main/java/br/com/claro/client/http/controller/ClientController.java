package br.com.claro.client.http.controller;

import br.com.claro.client.entity.Client;
import br.com.claro.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> list(){
        return clientService.list();
    }

    @GetMapping("/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Client> findClientById(@PathVariable Long id){
        return clientService.findById(id)
                .map(clientFound -> ResponseEntity.ok().body(clientFound))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    //@ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> create(@RequestBody Client client){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(clientService.create(client));
    }

    @PutMapping("{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody Client client){
        return clientService.update(id, client)
                .map(clientFound -> ResponseEntity.ok().body(clientFound))
                .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (clientService.delete(id)) {
            return ResponseEntity.noContent().<Void>build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
