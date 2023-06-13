public class Viande extends Frais {

    public Viande(String animal, int quantite, int dlc) {
        super(animal, quantite, dlc);
    }

    public String toString() {
        return "Sachet de viande de " + super.toString();
    }

    public Viande clone() {
        return new Viande(nom, quantite, dlc);
    }

}
