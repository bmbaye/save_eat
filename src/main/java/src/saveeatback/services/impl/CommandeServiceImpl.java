package src.saveeatback.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.Commande;
import src.saveeatback.datas.repositories.CommandeRepository;
import src.saveeatback.services.CommandeService;

import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {
    private final CommandeRepository commandeRepository;

    CommandeServiceImpl(CommandeRepository commandeRepository){
        this.commandeRepository =commandeRepository;
    }
    @Override
    public Optional<Commande> getOne(String id) {
        return this.commandeRepository.findById(id);
    }

    @Override
    public Page<Commande> getAll(Pageable pageable) {
        return this.commandeRepository.findAll(pageable);
    }

    @Override
    public Commande create(Commande commande) {
        return this.commandeRepository.insert(commande);
    }

    @Override
    public Optional<Commande> getByClient(Client client) {
        return this.commandeRepository.findByClient(client);
    }
}
