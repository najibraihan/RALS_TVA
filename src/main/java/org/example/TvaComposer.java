package org.example;

import org.example.OperationsDesContribuables.Operation;
import org.example.OperationsDesContribuables.OperationType;
import org.example.TaxFactory.TaxFacade;
import org.example.TaxFactory.TvaRalsBienEqpTravaux;
import org.example.TaxFactory.TvaRalsPrestationService;

import java.util.ArrayList;
import java.util.List;

/**
 * TvaComposer: TVA Mixer
 */
public class TvaComposer implements TaxImpotComposer {

    @Override
    public double calculerRasParOperationParFrs(Operation operation) {

        if (operation.getOperationType().equals(OperationType.BIENEQUIPEMENTSTRAVAUX)) {

            return TvaRalsBienEqpTravaux.calculateRalsTaux(operation) * TaxFacade.calculerTva(operation);

        } else if (operation.getOperationType().equals(OperationType.PRESTATIONDESERVICE)) {

            return TvaRalsPrestationService.calculateRalsTaux(operation) * TaxFacade.calculerTva(operation);
        }

        return 0;
    }


    public double calculerBetRasParMoisParFrs(ArrayList<Operation> operations) {
//      calculer RAS de fourniment des biens EQ/TV  par mois et par fournisseur
        List<Operation> operationsBet = TaxFacade.filterBetOperations(operations);

        return operationsBet.stream()
                .map(TaxFacade::calculerBetRasParOperationParFrs).reduce((double) 0, Double::sum);

    }


    public double calculerPreServRasParMoisParFrs(ArrayList<Operation> operations) {
//      calculer RAS des Presta par mois et par fournisseur
        double sm = 0, montantDepassePlafondCinqMilles = 0, smi = 0;
        int indiceOperationDepasseCinquanteMilles = -1;

        List<Operation> operationsPs = TaxFacade.filterPsOperations(operations);

        for (Operation operation : operationsPs) {

            if (operation.getMontant() >= 5000) {
                montantDepassePlafondCinqMilles += TaxFacade.calculerPsRasParOperationParFrs(operation);
            }

            sm += operation.getMontant();
            if (sm >= 50000) {
                indiceOperationDepasseCinquanteMilles = operationsPs.indexOf(operation);
                break;
            }
        }

        if (indiceOperationDepasseCinquanteMilles != -1) {
            smi = operationsPs.subList(indiceOperationDepasseCinquanteMilles, operationsPs.size()).stream()
                    .map(this::calculerRasParOperationParFrs).reduce((double) 0, Double::sum);

        }
        return montantDepassePlafondCinqMilles + smi;
    }

    @Override
    public double calculerRasParMoisParFrs(ArrayList<Operation> operations) {
        return calculerPreServRasParMoisParFrs(operations) + calculerBetRasParMoisParFrs(operations);
    }
}
