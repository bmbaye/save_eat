package src.saveeatback.datas.mocks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Commande;
import src.saveeatback.datas.entities.Livraison;
import src.saveeatback.datas.entities.Paiement;
import src.saveeatback.datas.entities.ProduitCommande;
import src.saveeatback.datas.enums.*;
import src.saveeatback.datas.repositories.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Component
public class CommandeMock implements CommandLineRunner {
    private final CommandeRepository cmdRepository;
    private final LivreurRepository livreurRepository;
    private final ClientRepository clientRepository;
    private final PaiementRepository paiementRepository;
    private final LivraisonRepository livraisonRepository;
    CommandeMock(CommandeRepository cmdRepository, LivreurRepository livreurRepository, ClientRepository clientRepository, PaiementRepository paiementRepository, LivraisonRepository livraisonRepository){
        this.cmdRepository =cmdRepository;
        this.livreurRepository =livreurRepository;
        this.clientRepository = clientRepository;
        this.paiementRepository = paiementRepository;
        this.livraisonRepository = livraisonRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        List<ProduitCommande> produits = new ArrayList<>();
        ProduitCommande prod = new ProduitCommande();
        prod.setPrix(1000.00);
        prod.setLibelle("Pasteque");
        prod.setQteCommande(2);
        prod.setId("68825313dd2b87ff4ca81fed");

        produits.add(prod);

        Livraison livraison = new Livraison();
        livraison.setType(TypeLivraison.SIMPLE);
        livraison.setEtat(EtatLivraison.EN_OPERATION);
        livraison.setLivreur(livreurRepository.findById("6883a7041fbac3c89e73be2b").get());
        livraison.setRue("WN rue-246");
        livraison.setVille("Guediawaye");
        livraison.setHoraire(HoraireLivraison.MATIN);
        Date date = Date.from(LocalDate.parse("2025-07-25").atStartOfDay(ZoneId.systemDefault()).toInstant());
        livraison.setDateLivraison(date);

        Livraison livr = this.livraisonRepository.save(livraison);


        Commande cmd =new Commande();
        cmd.setProduits(produits);
        cmd.setLivraison(livr);
        cmd.setClient(this.clientRepository.findById("6883a7021fbac3c89e73be29").get());
        cmd.setEtatCommande(EtatCommande.EN_ATTENTE);

        Paiement paiement = new Paiement();
        paiement.setDateEffectuee(null);
        paiement.setMontant(2000.0);
        paiement.setType(TypePaiement.CASH);
        paiement.setEtat(EtatPaiement.A_EFFECTUER);

        Paiement pmnt = paiementRepository.save(paiement);

        cmd.setPaiement(pmnt);
        cmd.setNombrePoduits(1);

        this.cmdRepository.save(cmd);

        System.out.println("Commande ajoutee avec succes");

    }
}
