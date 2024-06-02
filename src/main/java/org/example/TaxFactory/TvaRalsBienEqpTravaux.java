package org.example.TaxFactory;

import org.example.Contribuables.Clients.PuplicClient;
import org.example.OperationsDesContribuables.Operation;

public class TvaRalsBienEqpTravaux implements TvaRalsFactory {

    public static double calculateRalsTaux(Operation operation) {

        if (operation.getClient() instanceof PuplicClient) {

            if (((PuplicClient) operation.getClient()).isReglementationMarchePublic()) {
                return 0;
            }

        }

        if (operation.getFournisseur().isHasAttestationDeRegularite() ){
            return 0;
        }

        return 1;
    }
}
