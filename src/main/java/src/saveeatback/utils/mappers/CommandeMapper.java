package src.saveeatback.utils.mappers;

import org.springframework.stereotype.Component;
import src.saveeatback.datas.entities.Client;
import src.saveeatback.datas.entities.Commande;
import src.saveeatback.datas.entities.Paiement;
import src.saveeatback.datas.enums.EtatCommande;
import src.saveeatback.datas.enums.EtatPaiement;
import src.saveeatback.datas.enums.TypeLivraison;
import src.saveeatback.datas.enums.TypePaiement;
import src.saveeatback.datas.repositories.ClientRepository;
import src.saveeatback.web.dtos.requests.CommandeSubmittedDto;
import src.saveeatback.web.dtos.requests.ProduitCommandeDto;
import src.saveeatback.web.dtos.responses.commandes.CommandeResponse;

import java.util.List;
import java.util.Optional;

@Component
public class CommandeMapper {
    private final ClientRepository clientRepository;
    private final LivraisonMapper livraisonMapper;
    private final ProduitMapper produitMapper;

    public CommandeMapper(ClientRepository clientRepository, LivraisonMapper livraisonMapper, ProduitMapper produitMapper){
        this.clientRepository = clientRepository;
        this.livraisonMapper =livraisonMapper;
        this.produitMapper = produitMapper;
    }
    public Commande toCommandeEntity(CommandeSubmittedDto commandeDto){
        Double montant = getMontantCmd(commandeDto.getProduits(), TypeLivraison.valueOf(commandeDto.getLivraison().getType().toUpperCase()));
        Optional<Client> client = clientRepository.findById(commandeDto.getClientId());

        Paiement paiement = new Paiement();
        paiement.setType(TypePaiement.valueOf(commandeDto.getTypePaiement().toUpperCase()));
        paiement.setEtat(EtatPaiement.A_EFFECTUER);
        paiement.setMontant(montant);
        paiement.setDateEffectuee(null);

        Commande commande = new Commande();
        commande.setClient(client.get());
        commande.setEtatCommande(EtatCommande.EN_ATTENTE);
        commande.setPaiement(paiement);
        commande.setNombrePoduits(commandeDto.getProduits().size());
        commande.setLivraison(livraisonMapper.toLivraison(commandeDto.getLivraison()));
        commande.setProduits(commandeDto.getProduits().stream().map(this.produitMapper::toProduitCommandeRequest).toList());

        return commande;
    }

    private Double getMontantCmd(List<ProduitCommandeDto> produits, TypeLivraison typeLivraison){
        Double prixTotal = produits.stream().mapToDouble(ProduitCommandeDto::getPrix).sum();
        Double coutLivraison = typeLivraison == TypeLivraison.SIMPLE ? 1000.0 : 2000.0;

        return prixTotal+coutLivraison;
    }

    public CommandeResponse toCommandeResponse(Commande commande){
        return CommandeResponse.builder()
                .setId(commande.getId())
                .setClientId(commande.getClient().getId())
                .setEtatCommande(commande.getEtatCommande())
                .setLivraisonId(commande.getLivraison().getId())
                .setMontant(commande.getPaiement().getMontant())
                .setTypePaiement(commande.getPaiement().getType())
                .setProduits(commande.getProduits().stream().map(this.produitMapper::toProduitCmdResponse).toList())
                .setNombrePoduits(commande.getNombrePoduits())
                .build();
    }
}
