package org.example;

import org.example.OperationsDesContribuables.Operation;

import java.util.ArrayList;

public interface TaxImpotComposer {

    //    calculer RAS par jour et par fournissuer
    double calculerRasParOperationParFrs(Operation operation);

    //    calculer RAS des operations par mois et par fournisseur
    double calculerRasParMoisParFrs(ArrayList<Operation> operations);
}
