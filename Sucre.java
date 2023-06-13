public class Sucre extends Sec {
    public Sucre(String nom, int quantite) {
        super(nom, quantite);
    }

    public String toString() {
        return "Paquets de sucre " + super.toString();
    }

    public Sucre clone() {
        return new Sucre(nom, quantite);
    }
}
