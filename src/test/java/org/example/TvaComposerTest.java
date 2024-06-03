package org.example;

import junit.framework.TestCase;
import org.example.Contribuables.Clients.Client;
import org.example.Contribuables.Clients.PmClient;
import org.example.Contribuables.Fournisseurs.PmFournisseur;
import org.example.Contribuables.Fournisseurs.PpFournisseur;
import org.example.OperationsDesContribuables.Operation;
import org.example.OperationsDesContribuables.OperationType;

import java.util.ArrayList;

public class TvaComposerTest extends TestCase {

    protected TvaComposer tvaComposer = new TvaComposer();
    protected ArrayList<Operation> operationsPp, operationsPpa, operationsPm, operationsPmA;

    public void setUp() throws Exception {

        Client pmc = new PmClient(true);
        OperationType operationPsType = OperationType.PRESTATIONDESERVICE;
        OperationType operationBetType = OperationType.BIENEQUIPEMENTSTRAVAUX;

        /*
        ->A (Personne physique) n’ayant pas
        présenté l’attestation de régularité
        fiscale
        01/08/24 Service de nettoyage 3 500,00
        10/08/24 Service de gardiennage 30 000,00
        30/08/24 Service de jardinage 4 500,00
        **/

        PpFournisseur ppFournisseur = new PpFournisseur(true, false);
        operationsPp = new ArrayList<Operation>() {
        };
        operationsPp.add(new Operation(operationPsType, pmc, ppFournisseur, 3500d, "Service de nettoyage", 0.2));
        operationsPp.add(new Operation(operationPsType, pmc, ppFournisseur, 30000d, "Service de gardiennage", 0.2));
        operationsPp.add(new Operation(operationPsType, pmc, ppFournisseur, 500d, "Service de jardinage", 0.2));


        /*
        ->B (Personne physique) ayant
        présenté l’attestation de régularité
        fiscale
        02/08/24 Service de montage 3 500,00
        05/08/24 Assistance technique 45 000,00
        25/08/24 Entretien de matériel 4 500,00
        **/
        PpFournisseur ppFournisseurAt = new PpFournisseur(true, true);
        operationsPpa = new ArrayList<Operation>() {
        };
        operationsPpa.add(new Operation(operationPsType, pmc, ppFournisseurAt, 3500d, "Service de montag", 0.2));
        operationsPpa.add(new Operation(operationPsType, pmc, ppFournisseurAt, 45000d, "Assistance technique", 0.2));
        operationsPpa.add(new Operation(operationPsType, pmc, ppFournisseurAt, 4500d, "Entretien de matériel", 0.2));

        /*
        ->C (Personne Morale) n’ayant pas
        présenté l’attestation de régularité
        fiscale
        06/08/24 Service de réparation 15 000,00
        15/08/24 Machine industrielle 600 000,00
        20/08/24 Marchandises destinées à
        la vente 30 000,00
        **/
        PmFournisseur pmFournisseur = new PmFournisseur(true, false);
        operationsPm = new ArrayList<Operation>() {
        };
        operationsPm.add(new Operation(operationPsType, pmc, pmFournisseur, 15000d, "Service de réparation", 0.2));
        operationsPm.add(new Operation(operationBetType, pmc, pmFournisseur, 600000d, "Machine industrielle", 0.2));
        operationsPm.add(new Operation(null, pmc, pmFournisseur, 30000d, "Marchandises destinées la vente", 0.2));

        /*
        ->D (Personne Morale) ayant présenté
        l’attestation de régularité fiscale 14/08/24 Travaux de construction 300 000,00
        **/
        PmFournisseur pmFournisseurAt = new PmFournisseur(true, true);
        operationsPmA = new ArrayList<Operation>() {
        };
        operationsPmA.add(new Operation(operationBetType, pmc, pmFournisseurAt, 300000d, "Travaux de construction", 0.2));


    }

    public void testCalculerRasParMoisParFrs() {
        assertEquals(5000.0, tvaComposer.calculerRasParMoisParFrs(operationsPp));
        assertEquals(6187.5, tvaComposer.calculerRasParMoisParFrs(operationsPpa));
        assertEquals(100000.0, tvaComposer.calculerRasParMoisParFrs(operationsPm));
        assertEquals(0.0, tvaComposer.calculerRasParMoisParFrs(operationsPmA));
    }
}
