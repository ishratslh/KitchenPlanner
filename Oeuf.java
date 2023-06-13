public class Oeuf extends Frais {

    public Oeuf(String nom, int quantite, int dlc) {
        super(nom, quantite, dlc);
    }

    public String toString() {
        return "Oeuf de " + super.toString();
    }

    public Oeuf clone() {
        return new Oeuf(nom, quantite, dlc);
    }
}
