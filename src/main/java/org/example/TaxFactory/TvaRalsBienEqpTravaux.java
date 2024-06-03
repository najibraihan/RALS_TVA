package org.example.TaxFactory;

import org.example.Contribuables.Clients.PuplicClient;
import org.example.OperationsDesContribuables.Operation;

/**
 * TvaRalsBienEqpTravaux : RALS factory de "fournisseurs de biens d’équipement et de travaux"
 */
public class TvaRalsBienEqpTravaux implements TvaRalsFactory {

    /**
     * Calculer le taux de la RAS concerant "fournir des biens d’équipement et de travaux"
     *
     * @param operation: l'operation effectuee
     * @return Le taux de RAS
     */
    public static double calculateRalsTaux(Operation operation) {

        if (operation.getClient() instanceof PuplicClient) {

            if (((PuplicClient) operation.getClient()).isReglementationMarchePublic()) {
                return 0;
            }

        }

        if (operation.getFournisseur().isHasAttestationDeRegularite()) {
            return 0;
        }

        return 1;
    }
}
