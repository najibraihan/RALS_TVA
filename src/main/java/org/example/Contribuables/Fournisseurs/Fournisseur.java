package org.example.Contribuables.Fournisseurs;

import org.example.Contribuables.Contribuable;

public class Fournisseur extends Contribuable {

    protected boolean hasAttestationDeRegularite = false;

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
