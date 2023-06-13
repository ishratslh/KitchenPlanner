public abstract class Frais extends Aliment implements Perissable {
    protected int dlc;

    public Frais(String nom, int quantite, int dlc) {
        super(nom, quantite);
        this.dlc = dlc;
    }

    public String toString() {
        return super.toString() + ", aliment frais, DLC : " + dlc;
    }

    public boolean aJeter() {
        return (dlc <= 0);
    }

    public int getDlc() {
        return dlc;
    }

    public boolean equals(Frais a) {
        return super.equals(a) && (dlc == a.dlc);
    }

}
