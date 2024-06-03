package org.example.OperationsDesContribuables;

import org.example.Contribuables.Clients.Client;
import org.example.Contribuables.Fournisseurs.Fournisseur;


/**
 * Operation effectuee
 */
public class Operation {

    protected OperationType operationType;
    protected Client client;
    protected Fournisseur fournisseur;
    protected Double montant;
    protected String operationTitre;
    protected Double tauxTva;

    public Operation(OperationType operationType, Client client, Fournisseur fournisseur, Double montant, String operationTitre, Double tauxTva) {
        this.operationType = operationType;
        this.client = client;
        this.fournisseur = fournisseur;
        this.montant = montant;
        this.operationTitre = operationTitre;
        this.tauxTva = tauxTva;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(Double tauxTva) {
        this.tauxTva = tauxTva;
    }

    public String getOperationTitre() {
        return operationTitre;
    }

    public void setOperationTitre(String operationTitre) {
        this.operationTitre = operationTitre;
    }
}
