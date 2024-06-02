package org.example.TaxFactory;


import org.example.Contribuables.Clients.PuplicClient;
import org.example.Contribuables.Fournisseurs.PmFournisseur;
import org.example.OperationsDesContribuables.Operation;

import java.util.Arrays;

public class TvaRalsPrestationService implements TvaRalsFactory{

    static final String[] prestationExclues = new String[]{
            "ventes_energie_electrique",
            "eau_reseaux_distribution_publique",
            "assainissement_fournis_aux_abonnes",
            " location_de_compteurs",
            "operateurs_de_telecommunication",
            "agent_demarcheur_courtier_assurances"
    };

    public static boolean verifierSiExclus(Operation operation){
        return Arrays.stream(prestationExclues).anyMatch(prestation -> prestation.equals(operation.getOperationTitre()));
    }


    public static double calculateRalsTaux(Operation operation) {

        if (verifierSiExclus(operation)){
            return 0;
        }
        else if (operation.getClient() instanceof PuplicClient) {
            return 0.75;
        }
        else if (operation.getFournisseur() instanceof PmFournisseur) {
            return 0;
        }
        else if (operation.getFournisseur().isHasAttestationDeRegularite()) {
            return 0.75;
        }
        else {
            return 1;
        }

    }
}
