public abstract class Aliment {
    protected String nom;
    protected int quantite;

    public Aliment(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public String toString() {
        return nom + " (quantité : " + quantite + ")";
    }

    public int getQuantite() {
        return quantite;
    }

    public String getNom() {
        return nom;
    }

    public boolean equals(Aliment a) {
        return (nom == a.nom) && (quantite == a.quantite);
    }

    public abstract Aliment clone();

}
