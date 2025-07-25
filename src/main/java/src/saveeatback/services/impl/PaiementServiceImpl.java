package src.saveeatback.services.impl;

import org.springframework.stereotype.Service;
import src.saveeatback.datas.entities.Paiement;
import src.saveeatback.datas.repositories.PaiementRepository;
import src.saveeatback.services.PaiementService;

@Service
public class PaiementServiceImpl implements PaiementService {
    private final PaiementRepository paiementRepository;

    PaiementServiceImpl(PaiementRepository paiementRepository){
        this.paiementRepository =paiementRepository;
    }
    @Override
    public Paiement create(Paiement paiement) {
        return this.paiementRepository.save(paiement);
    }
}
