package org.example.TaxFactory;

import org.example.OperationsDesContribuables.Operation;
import org.example.OperationsDesContribuables.OperationType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaxFacade {
    public static double calculerTva(Operation operation) {
        return (operation.getMontant() / (1 + operation.getTauxTva())) * operation.getTauxTva();
    }

    public static double calculerPsRasParOperationParFrs(Operation operation) {
        return TvaRalsPrestationService.calculateRalsTaux(operation) * calculerTva(operation);

    }

    public static double calculerBetRasParOperationParFrs(Operation operation) {
        return TvaRalsBienEqpTravaux.calculateRalsTaux(operation) * calculerTva(operation);

    }

    public static List<Operation> filterPsOperations(ArrayList<Operation> operations) {

        return operations.stream()
                .filter(operation -> operation.getOperationType() != null)
                .filter(operation -> operation.getOperationType().equals(OperationType.PRESTATIONDESERVICE))
                .collect(Collectors.toList());
    }

    public static List<Operation> filterBetOperations(ArrayList<Operation> operations) {
        return operations.stream()
                .filter(operation -> operation.getOperationType() != null)
                .filter(operation -> operation.getOperationType().equals(OperationType.BIENEQUIPEMENTSTRAVAUX))
                .collect(Collectors.toList());
    }
}
