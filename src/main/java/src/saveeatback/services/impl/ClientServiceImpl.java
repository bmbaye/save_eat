package src.saveeatback.services.impl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.repositories.ClientRepository;
import src.saveeatback.services.ClientService;

import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository =clientRepository;
    }
    @Override
    public Page<Client> getAllClients(Pageable pageable) {
        return this.clientRepository.findAll(pageable);
    }

    @Override
    public Client create(Client client) {
        return this.clientRepository.insert(client);
    }

    @Override
    public Optional<Client> getOne(String id) {
        return this.clientRepository.findById(id);
    }

    @Override
    public Optional<Client> getByTelephone(String telephone) {
        return this.clientRepository.findByTelephone(telephone);
    }
}
