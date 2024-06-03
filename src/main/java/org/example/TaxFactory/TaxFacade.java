package org.example.TaxFactory;

import org.example.OperationsDesContribuables.Operation;
import org.example.OperationsDesContribuables.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TaxFacade: helper methods
 */
public class TaxFacade {
    public static double calculerTva(Operation operation) {
//        Calculer le montant de TVA
        return (operation.getMontant() / (1 + operation.getTauxTva())) * operation.getTauxTva();
    }

    public static double calculerPsRasParOperationParFrs(Operation operation) {
//        Calculer le montant de la RALS de Prestation de service par operation et par fournisseur
        return TvaRalsPrestationService.calculateRalsTaux(operation) * calculerTva(operation);

    }

    public static double calculerBetRasParOperationParFrs(Operation operation) {
//        Calculer le montant de la RALS de fournir les biens d'equipement et travaux par operation et par fournisseur
        return TvaRalsBienEqpTravaux.calculateRalsTaux(operation) * calculerTva(operation);

    }

    public static List<Operation> filterPsOperations(ArrayList<Operation> operations) {
//          filtrer les operations de Prestation de service
        return operations.stream()
                .filter(operation -> operation.getOperationType() != null)
                .filter(operation -> operation.getOperationType().equals(OperationType.PRESTATIONDESERVICE))
                .collect(Collectors.toList());
    }

    public static List<Operation> filterBetOperations(ArrayList<Operation> operations) {
//          filtrer les operations de fournir les biens d'equipement et travaux
        return operations.stream()
                .filter(operation -> operation.getOperationType() != null)
                .filter(operation -> operation.getOperationType().equals(OperationType.BIENEQUIPEMENTSTRAVAUX))
                .collect(Collectors.toList());
    }
}
