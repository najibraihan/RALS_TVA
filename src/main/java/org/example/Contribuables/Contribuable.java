package org.example.Contribuables;

/**
 * Classe de Contribuable
 */
public class Contribuable {

    /**
     * les clients/fournisseurs assujettis ou non ?
     */
    protected boolean isAssujettis;

    public Contribuable(boolean assujet) {
        isAssujettis = assujet;
    }

    public boolean isAssujettis() {
        return isAssujettis;
    }

    public void setAssujettis(boolean assujettis) {
        isAssujettis = assujettis;
    }
}
