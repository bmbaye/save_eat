package src.saveeatback.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Livreur;
import src.saveeatback.datas.repositories.LivreurRepository;
import src.saveeatback.services.LivreurService;

import java.util.Optional;

@Service
public class LivreurServiceImpl implements LivreurService {
    private final LivreurRepository livreurRepository;

    LivreurServiceImpl(LivreurRepository livreurRepository){
        this.livreurRepository = livreurRepository;
    }
    @Override
    public Page<Livreur> getAllServices(Pageable pageable) {
        return this.livreurRepository.findAll(pageable);
    }

    @Override
    public Optional<Livreur> getOne(String id) {
        return this.livreurRepository.findById(id);
    }

    @Override
    public Optional<Livreur> getOneByTelephone(String telephone) {
        return this.livreurRepository.findByTelephone(telephone);
    }

    @Override
    public Livreur create(Livreur livreur) {
        return this.livreurRepository.insert(livreur);
    }
}
