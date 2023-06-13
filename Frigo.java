public class Frigo {
    private static final Frigo Instance = new Frigo();
    private static final int capacite_max = 50; //nb d'aliments max
    private static int nb_aliments = 0; //nb d'aliments total
    private static int comp = 0; //compteur du frigo
    private Frais[] frigo;

    private Frigo() {
        frigo = new Frais[capacite_max];
    }

    public static Frigo getInstance() {
        return Instance;
    }

    public void ajouterAliment(Frais aliment) throws PleinException {
        if (nb_aliments + aliment.getQuantite() >= capacite_max) { //Trop d'aliments dans le frigo
            throw new PleinException();
        } else {
            frigo[comp] = aliment; //Pour que chaque case du tableau frigo soit remplie quantite fois de l'aliment
            nb_aliments += aliment.getQuantite();
            comp++;
        }
    }

    public int getNbAliments() {
        return nb_aliments;
    }

    public void retirerAliment(Frais aliment) {
        int i = 0;
        while ((!frigo[i].equals(aliment)) && i < comp) {
            i++;
        }
        if (i == comp) { //L'aliment en paramètre n'est pas dans le frigo
            System.out.println("L'aliment n'est pas dans le frigo");
        } else { //frigo[i] est l'aliment à retirer
            nb_aliments -= frigo[i].getQuantite();
            comp--;
            while (i < comp) {
                frigo[i] = frigo[i + 1];
                i++;
            }
            frigo[i] = null;
        }
    }


    public void viderFrigo() { //retire les aliments perimés
        int i = 0;
        while (i < comp) {
            if (frigo[i].aJeter()) {
                retirerAliment(frigo[i]);
                i--;
            }
            i++;
        }
    }

    public boolean alimentPresent(Frais a) {
        int comp2 = 0; //compteur de quantité d'al si l'aliment est présent dans le frigo mais pas en quantité suffisante
        for (int al = 0; al < comp; al++) {
            if ( frigo[al].getClass() == (a.getClass()) ) {

                if ((frigo[al].getQuantite() + comp2) >= a.getQuantite()) {
                    return true;
                } else {
                    comp2 = comp2 + frigo[al].getQuantite();
                }
            }
        }
        return false;
    }


    public boolean recetteRealisableF(Recette r) {
        Frais[] ing = r.getIngredientsF();

        int al = 0;
        while (ing[al] != null) {
            if (! this.alimentPresent(ing[al])) {
                return false;
            }
            al++;
        }
        return true;
    }

    public void avancerJour() {
        for (int al = 0; al < comp ; al++) {
            frigo[al].dlc -= 1;
        }
    }

    public String toString() {
        int i = 0;
        String s = "Dans le réfrigérateur, nous avons : \n";
        while (frigo[i] != null) {
            s += frigo[i] + "\n";
            i++;
        }
        return s;
    }

}
