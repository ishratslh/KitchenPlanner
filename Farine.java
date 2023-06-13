public class Farine extends Sec {
    public Farine(String nom, int quantite) {
        super(nom, quantite);
    }

    public String toString() {
        if (quantite == 1) {
            return "Paquet de farine " + super.toString();
        }
        return "Paquets de farine " + super.toString();
    }

    public Farine clone() {
        return new Farine(nom, quantite);
    }
}
