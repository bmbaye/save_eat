package src.saveeatback.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Livraison;
import src.saveeatback.datas.repositories.LivraisonRepository;
import src.saveeatback.services.LivraisonService;

import java.util.Date;
import java.util.Optional;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    private final LivraisonRepository livraisonRepository;

    LivraisonServiceImpl(LivraisonRepository livraisonRepository){
        this.livraisonRepository = livraisonRepository;
    }
    @Override
    public Page<Livraison> getAllLivraisons(Pageable pageable) {
        return this.livraisonRepository.findAll(pageable);
    }

    @Override
    public Optional<Livraison> getOne(String id) {
        return this.livraisonRepository.findById(id);
    }

    @Override
    public Page<Livraison> getByDateLivraison(Date date, Pageable pageable) {
        return this.livraisonRepository.findAllByDateLivraison(date, pageable);
    }

    @Override
    public Livraison create(Livraison livraison) {
        return this.livraisonRepository.save(livraison);
    }
}
