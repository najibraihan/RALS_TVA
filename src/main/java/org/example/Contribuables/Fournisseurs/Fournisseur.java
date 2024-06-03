package org.example.Contribuables.Fournisseurs;

import org.example.Contribuables.Contribuable;

/**
 * Fournisseur
 */
public class Fournisseur extends Contribuable {

    /**
     * ayant présenté l’attestation justifiant leur régularité fiscale précitée au titre des obligations
     * de déclaration et de paiement des impôts, droits et taxes prévus par le CGI ou non ?
     */
    protected boolean hasAttestationDeRegularite;


    public Fournisseur(boolean assujet, boolean attestation) {
        super(assujet);
        hasAttestationDeRegularite = attestation;
    }

    public boolean isHasAttestationDeRegularite() {
        return hasAttestationDeRegularite;
    }

    public void setHasAttestationDeRegularite(boolean hasAttestationDeRegularite) {
        this.hasAttestationDeRegularite = hasAttestationDeRegularite;
    }


}
