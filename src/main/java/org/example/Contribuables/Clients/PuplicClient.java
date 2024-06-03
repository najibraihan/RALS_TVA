package org.example.Contribuables.Clients;

/**
 * * Client: (Etablissement d'etat)
 */
public class PuplicClient extends Client {

    /**
     * la réglementation relative aux marchés publics ou non ?.
     */
    protected boolean isReglementationMarchePublic;

    public PuplicClient(boolean assujet, boolean isReglementationMarcPuhblic) {
        super(assujet);
        isReglementationMarchePublic = isReglementationMarcPuhblic;
    }

    public boolean isReglementationMarchePublic() {
        return isReglementationMarchePublic;
    }

    public void setReglementationMarchePublic(boolean reglementationMarchePublic) {
        isReglementationMarchePublic = reglementationMarchePublic;
    }
}
