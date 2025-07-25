package src.saveeatback.utils.mappers;

import src.saveeatback.datas.entities.Commande;
import src.saveeatback.datas.enums.EtatCommande;
import src.saveeatback.web.dtos.requests.CommandeSubmittedDto;
import src.saveeatback.web.dtos.responses.commandes.CommandeResponse;

public class CommandeMapper {
    public static Commande toCommandeEntity(CommandeSubmittedDto commandeDto){
        Commande commande = new Commande();
        commande.setClient(commandeDto.getClient());
        commande.setEtatCommande(EtatCommande.EN_ATTENTE);
        commande.setPaiement(PaiementMapper.toPaiement(commandeDto.getPaiement()));
        commande.setNombrePoduits(commandeDto.getProduits().size());
        commande.setLivraison(LivraisonMapper.toLivraison(commandeDto.getLivraison()));
        commande.setProduits(commandeDto.getProduits().stream().map(ProduitMapper::toProduitCommandeRequest).toList());

        return commande;
    }

    public static CommandeResponse toCommandeResponse(Commande commande){
        return CommandeResponse.builder()
                .setId(commande.getId())
                .setClientId(commande.getClient().getId())
                .setEtatCommande(commande.getEtatCommande())
                .setLivraisonId(commande.getLivraison().getId())
                .setMontant(commande.getPaiement().getMontant())
                .setTypePaiement(commande.getPaiement().getType())
                .setProduits(commande.getProduits().stream().map(ProduitMapper::toProduitCmdResponse).toList())
                .setNombrePoduits(commande.getNombrePoduits())
                .build();
    }
}
