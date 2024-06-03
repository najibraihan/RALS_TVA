package org.example.Contribuables.Clients;

public class PuplicClient extends Client {

    protected boolean isReglementationMarchePublic = false;

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
