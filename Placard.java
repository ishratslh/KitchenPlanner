public class Placard {
    private static final Placard Instance = new Placard();
    private static final int capacite_max = 25; //nb d'aliments max
    private static int nb_aliments = 0; //nb d'aliments courant
    private static int comp = 0; //compteur
    private Sec[] placard;

    private Placard() {
        placard = new Sec[capacite_max];
    }

    public static Placard getInstance() {
        return Instance;
    }

    public void ajouterAliment(Sec aliment) throws PleinException {
        if (nb_aliments + aliment.getQuantite() >= capacite_max) { //Trop d'aliments dans le placard
            throw new PleinException();
        } else {
            placard[comp] = aliment; //Pour que chaque case du tableau frigo soit remplie quantite fois de l'aliment
            nb_aliments += aliment.getQuantite();
            comp++;
        }
    }

    public int getNbAliments() {
        for (int a = 0; a < placard.length; a++) {
            nb_aliments += placard[a].getQuantite();
        }
        return nb_aliments;
    }

    public void retirerAliment(Sec aliment) {
        int i = 0;
        while ((!placard[i].equals(aliment)) && i < comp) {
            i++;
        }
        if (i == comp) { //L'aliment en paramètre n'est pas dans le placard
            System.out.println("L'aliment n'est pas dans le placard");
        } else { //placard[i] est l'aliment à retirer
            nb_aliments -= placard[i].getQuantite();
            comp--;
            while (i < comp) {
                placard[i] = placard[i + 1];
                i++;
            }
            placard[i] = null;
        }

    }


    public String toString() {
        int i = 0;
        String s = "Dans le placard, nous avons : \n";
        while (placard[i] != null) {
            s += placard[i] + "\n";
            i++;
        }
        return s;
    }


    public boolean alimentPresent(Sec a) {
        int comp2 = 0; //compteur de quantité d'al si l'aliment est présent dans le frigo mais pas en quantité suffisante
        int al = 0;
        while (placard[al] != null) {
            if ((placard[al].getClass()) == (a.getClass())) {

                if ((placard[al].getQuantite() + comp2) >= a.getQuantite()) {
                    return true;
                } else {
                    comp2 = comp2 + placard[al].getQuantite();
                }
            }
            al++;
        }
        return false;
    }


    public boolean recetteRealisableS(Recette r) {
        int i = 0;
        Sec[] ing = r.getIngredientsS();

        while (ing[i] != null) {
            if (this.alimentPresent(ing[i])) {
                i++;
            } else {
                return false;
            }
        }
        return true;
    }


}
