package org.example.Contribuables;

public abstract class Contribuable {

    protected boolean isAssujettis = false;

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
