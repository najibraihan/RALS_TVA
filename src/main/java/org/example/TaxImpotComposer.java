package org.example;

import org.example.OperationsDesContribuables.Operation;

import java.util.ArrayList;

public interface TaxImpotComposer {
    public double calculerRasParOperationParFrs(Operation operation);

    public double calculerPreServRasParMoisParFrs(ArrayList<Operation> operations);

    public double calculerBetRasParMoisParFrs(ArrayList<Operation> operations);

    public double calculerRasParMoisParFrs(ArrayList<Operation> operations);
}
