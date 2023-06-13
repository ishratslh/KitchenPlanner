public class Legume extends Frais {

    public Legume(String type, int quantite, int dlc) {
        super(type, quantite, dlc);
    }

    public String toString() {
        if (quantite == 1) {
            return "Légume : " + super.toString();
        }
        return "Légumes : " + super.toString();
    }

    public Legume clone() {
        return new Legume(nom, quantite, dlc);
    }
}
