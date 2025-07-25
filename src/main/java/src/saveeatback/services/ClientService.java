package src.saveeatback.services;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import src.saveeatback.datas.entities.Client;

import java.util.Optional;

public interface ClientService {
    Page<Client> getAllClients(Pageable pageable);
    Client create(Client client);
    Optional<Client> getOne(String id);
    Optional<Client> getByTelephone(String telephone);
}
