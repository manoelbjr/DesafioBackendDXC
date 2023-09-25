package br.com.claro.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.claro.client.entity.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {

}
