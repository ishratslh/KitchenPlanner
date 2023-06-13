public abstract class Sec extends Aliment {

    public Sec(String nom, int quantite) {
        super(nom, quantite);
    }

    public String toString() {
        return super.toString() + ", aliment à disposer au sec.";
    }

    public boolean aJeter() {
        return false;
    }

}
