public class Chocolat extends Sec {
    public Chocolat(String nom, int quantite) {
        super(nom, quantite);
    }

    public String toString() {
        return "Tablette de chocolat " + super.toString();
    }

    public Sucre clone() {
        return new Sucre(nom, quantite);
    }
}
