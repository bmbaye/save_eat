package src.saveeatback.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Produit;
import src.saveeatback.datas.repositories.ProduitRepository;
import src.saveeatback.services.ProduitService;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitRepository produitRepository){
        this.produitRepository = produitRepository;
    }
    @Override
    public Page<Produit> getProduits(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Produit create(Produit produit) {
        return produitRepository.insert(produit);
    }

    @Override
    public Optional<Produit> getOneProduit(String id) {
        return produitRepository.findById(id);
    }

    @Override
    public Optional<Produit> getByLibelle(String libelle) {
        return this.produitRepository.findByLibelle(libelle);
    }
}
