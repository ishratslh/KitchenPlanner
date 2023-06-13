public class Cuisine {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        //Initialisation des Recettes

        //Recette 1 : Tagliatelles au boeuf et aux légumes grillés
        Frais[] ingF1 = new Frais[4];
        Sec [] ingS1 = new Sec[1];

        Viande hache = new Viande("Haché à l'oignon", 1, 4);
        Legume tomate = new Legume("Tomate", 1, 14);
        Legume courgette = new Legume("Courgette", 1, 14);
        Oeuf poule = new Oeuf("Poule", 1, 21);

        Farine ble = new Farine("Blé", 1);
        ingF1[0] = tomate; //1 tomate
        ingF1[1] = courgette; //1 courgette
        ingF1[2] = hache; //1 sachet de 2 steaks hachés à l'oignon de 500g
        ingF1[3] = poule; //1 oeuf (pates)
        ingS1[0] = ble; //1paquet de 500g (pates)

        String [] et1 = new String[11];
        et1[0]="​Versez la farine dans un saladier. Faites une fontaine au centre et y casser les œufs.";
        et1[1]="Commencez à mélanger à la spatule en bois en ramenant au fur et à mesure la farine au centre jusqu’à ce qu’elle soit tout amalgamée.";
        et1[2]="Déposez alors la pâte sur un plan de travail fariné et pétrissez-la. Au bout de 5 à 10 minutes, vous allez obtenir une belle boule de pâte bien lisse.";
        et1[3]="Enroulez-la dans un torchon propre et gardez-la au frais 30 minutes.";
        et1[4]="Etaler et replier la pâte plusieurs fois en farinant bien à chaque fois. Ensuite, lorsque la pâte est bien fine, la découper. Pour des tagliatelles, enrouler la pâte sur elle-même puis découper de fines lamelles";
        et1[5]="Faire sécher une heure au moins, puis faire cuire.";

        et1[6]="Laver et découper la courgette en fines lamelles, et la tomate en morceaux.";
        et1[7]="Dans une sauteuse huilée, y jeter les morceaux de courgette.";
        et1[8]="Laisser rissoler 5 minutes puis ajouter les pâtes, de l'eau. Faire revenir.";
        et1[9]="Après une dizaine de minutes, ajouter les morceaux de tomate, la viande revenue à la poêle au préalable, et remuer.";
        et1[10]="Assaisonner et déguster sans attendre.";

        Recette r1 = new Recette("Tagliatelles au boeuf et aux légumes grillés", et1, ingF1, ingS1);


        //Recette 2 : Mousse au chocolat
        Frais[] ingF2 = {new Oeuf("Poule", 6, 14)};
        Sec[] ingS2 = {new Sucre("Semoule", 1), new Chocolat("Noir", 1)};

        String [] et2 = new String[5];
        et2[0] = "Battez les blancs en neige jusqu'à ce qu'ils soient bien fermes. Réservez-les au frais.";
        et2[1] = "Dans un autre saladier, mélangez les jaunes et le sucre jusqu'à obtenir une texture homogène. Réservez à température ambiante.";
        et2[2] = "Pendant ce temps, coupez la tablette de chocolat en morceaux puis faites-les fondre au bain-marie à feu moyen. Dès qu'il est fondu, incorporez-le aux jaunes d'oeufs et fouettez quelques instants.";
        et2[3] = "À l'aide d'une spatule, incorporez délicatement les blancs en neige à la préparation au chocolat.";
        et2[4] = "Conservez la mousse au chocolat au frais durant 5 heures puis servez-là dans des ramequins.";

        Recette r2 = new Recette("Mousse au chocolat", et2, ingF2, ingS2);



        //Initialisation du Frigo

        Frigo frigo = Frigo.getInstance();
        //aliments frais
        Oeuf o = new Oeuf("Poule", 2, 21);
        Oeuf o2 = new Oeuf("Poule", 10, 1);
        Viande v = new Viande("Boeuf", 4, 4);
        Viande v2 = new Viande("Poulet", 6, 1);
        Legume l = new Legume("Aubergine", 3, 14);
        Legume l2 = new Legume("Concombre", 2, 9);


        try {
            frigo.ajouterAliment(o);
            frigo.ajouterAliment(v);
            frigo.ajouterAliment(l);
            frigo.ajouterAliment(o2);
            frigo.ajouterAliment(v2);
            frigo.ajouterAliment(l2);
        } catch (PleinException e) {
            System.out.println("Frigo : " + e.getMessage());
        }



        //Initialisation du Placard

        Placard placard = Placard.getInstance();
        //aliments secs
        Farine f = new Farine("Blé", 2);
        Sucre s = new Sucre("Semoule", 3);
        Chocolat c = new Chocolat("Noir", 1);

        try {
            placard.ajouterAliment(f);
            placard.ajouterAliment(s);
            placard.ajouterAliment(c);
        } catch (PleinException e) {
            System.out.println("Placard : " + e.getMessage());
        }




        //Affichage dans le terminal et tests

        Cuisine.clearScreen();

        System.out.println("\n-----------------------------------------------------------------------------------------------");
        System.out.println("                              Bienvenue dans la cuisine !                             \n");

        System.out.println("Nombre d'aliments dans le frigo : " + frigo.getNbAliments());
        System.out.println(frigo.toString());
        System.out.println(placard.toString());

        frigo.avancerJour();
        frigo.viderFrigo();
        System.out.println("Après avoir vidé le frigo: \nNombre d'aliments dans le frigo : " +frigo.getNbAliments());
        System.out.println(frigo.toString());

        Viande v3 = new Viande("Poulet", 12, 0);
        System.out.println("Avons-nous 12 sachets de viande ? "+ frigo.alimentPresent(v3)+"\n");


        System.out.println("Avons-nous assez d'ingrédients dans le frigo pour nos tagliatelles? : "+frigo.recetteRealisableF(r1));
        System.out.println("Avons-nous assez d'ingrédients dans le placard pour nos tagliatelles? : "+placard.recetteRealisableS(r1));
        System.out.println(r1.toString());

        System.out.println("\n-----------------------------------------------------------------------------------------------");

    }
}
