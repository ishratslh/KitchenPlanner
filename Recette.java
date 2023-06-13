public class Recette {
    private String nom;
    private String [] etapes = new String[et_max]; //Etapes de la recette
    private static final int et_max = 20; //Nombre d'étapes max
    private int nb_et = 0; //Nombre d'étapes actuel
    private Frais [] ingredientsF = new Frais[ing_max]; //Liste des ingrédients frais
    private Sec [] ingredientsS = new Sec[ing_max]; //Liste des ingrédients secs
    private static final int ing_max = 10; //Nombre d'ingrédients max
    private int nb_ingF = 0; //Nombre d'ingrédients frais actuel
    private int nb_ingS = 0; //Nombre d'ingrédients secs actuel


    public Recette(String nom, String[] e, Frais[] ingF, Sec[] ingS) {

        this.nom = nom;

        //Ajout des etapes de la recette
        if (e.length > et_max) { //Trop d'etapes
            System.out.println("Il y a trop d'etapes, le maximum est : " + et_max);
            System.out.println("Les etapes de " + et_max + " a " + e.length + "  ne sont pas ajoutees.");
            while (nb_et < et_max) { //Ajout des et_max premières étapes
                etapes[nb_et] = e[nb_et];
                nb_et++;
            }
        } else { //Bon nombre d'etapes
            for (String et : e) {
                etapes[nb_et] = et;
                nb_et++;
            }
        }

        //Ajout des ingredients frais
        if (ingF.length > ing_max) { //Trop d'ingredients
            System.out.println("Il y a trop d'ingredients frais, le maximum est : " +ing_max);
            while (nb_ingF < ing_max) { //Ajout des ing_max premiers ingredients
                ingredientsF[nb_ingF] = ingF[nb_ingF];
                nb_ingF++;
            }
        } else { //Bon nombre d'ingredients frais
            for (Frais iF : ingF) {
                ingredientsF[nb_ingF] = iF;
                nb_ingF++;
            }
        }

        //Ajout des ingredients secs
        if (ingS.length > ing_max) { //Trop d'ingredients
            System.out.println("Il y a trop d'ingredients secs, le maximum est : " +ing_max);
            while (nb_ingS < ing_max) { //Ajout des ing_max premiers ingredients
                ingredientsS[nb_ingS] = ingS[nb_ingS];
                nb_ingS++;
            }
        } else { //Bon nombre d'ingredients secs
            for (Sec iS : ingS) {
                ingredientsS[nb_ingS] = iS;
                nb_ingS++;
            }
        }

    }

    public void ajout_etape(String etape) {
        if (nb_et >= et_max) {
            System.out.println("On ne peut pas ajouter plus d'étapes.");
        } else {
            etapes[nb_et] = etape;
            nb_et++;
        }
    }

    public void ajout_ingredientFrais(Frais ingF) {
        if (nb_ingF >= ing_max) {
            System.out.println("On ne peut pas ajouter plus d'ingrédients frais dans la recette.");
        }
        else {
            ingredientsF[nb_ingF] = ingF;
            nb_ingF++;
        }
    }

    public void ajout_ingredientSecs(Sec ingS) {
        if (nb_ingS >= ing_max) {
            System.out.println("On ne peut pas ajouter plus d'ingrédients secs dans la recette.");
        }
        else {
            ingredientsS[nb_ingS] = ingS;
            nb_ingS++;
        }
    }

    public String toString() {
        String res = "\nRecette : " + nom + "\n\nIngrédients :\n";
        for (int ing = 0; ing < nb_ingF; ing++) {
            res += ingredientsF[ing].getNom() + " : " + ingredientsF[ing].getQuantite() + "\n";
        }
        for (int ing = 0; ing < nb_ingS; ing++) {
            res += ingredientsS[ing].getNom() + " : " + ingredientsS[ing].getQuantite() + "\n";
        }

        res += "\nÉtapes :\n";
        for (int et = 0; et < nb_et; et++)  {
            res += etapes[et] + "\n";
        }
        return res;
    }

    public Frais[] getIngredientsF() {
        return ingredientsF;
    }

    public Sec[] getIngredientsS() {
        return ingredientsS;
    }


}
