import java.util.*;

public class Partie {

    public static final String ERREUR = "\u001B[31m";

    // ANSI escape code to reset text color
    public static final String ERREUR_RESET = "\u001B[0m";
    static Scanner sc = new Scanner(System.in);
    public static String[] nbJoueur(){

        String[] joueurs;
        int nbjoueurs;

        do{
            System.out.println("Combien de joueurs êtes-vous ? ( 4 maxi )");
            nbjoueurs = sc.nextInt();
            while((nbjoueurs<0)){
                System.out.println(ERREUR+"Erreur de saisie : veuillez recommencer \n"+ERREUR_RESET);
                System.out.println("Combien de joueurs êtes-vous ? ( 4 maxi )");
                nbjoueurs = sc.nextInt();
            }

            joueurs = new String[nbjoueurs];

        }while((nbjoueurs > 4 || nbjoueurs < 1));


        sc.nextLine(); // Ajout de cette ligne pour consommer la nouvelle ligne restante (probleme joueur1)

        for(int i = 0; i < nbjoueurs; i++){

            System.out.print("Veuillez choisir votre pseudo joueur n°"+(i+1)+" : ");
            joueurs[i]= sc.nextLine();
        }

        return joueurs;
    }


        public static void demarrerLaPartie() {
            String[][][] sachet = Outils.sachets();
            String[] joueurs = nbJoueur();
            Outils.dictionnaire();
            int sens;

            System.out.println();
            System.out.println("Bonjour à vous ! Bienvenue au jeu de Scrabble, à vous de jouer :)");
            System.out.println();

            // Premier tour du premier joueur
            premierTour(joueurs, sachet);

            // Boucle pour les tours suivants
            while (!Outils.finDePartie(sachet)) {
                for (int i = 1; i < joueurs.length; i++) {
                    tourDeJeu(joueurs[i], sachet,joueurs);
                    if (i == joueurs.length - 1) {
                        i = -1; // Réinitialiser pour revenir au premier joueur
                    }
                }
            }
        }

    public static void premierTour(String[] joueurs, String[][][] sachet) {
        Scanner sc = new Scanner(System.in);

        String mot;
        boolean motValide;
        int sens;
        char[] tirage;
        int points ;

        System.out.println("Premier tour - " + joueurs[0]);
        Plateau.afficherPlateauVide();

        do {
            System.out.println("Voici votre chevalet " + joueurs[0] + " :");
            tirage = Outils.premierTirage(sachet, joueurs[0]);

            for (char var : tirage) {
                System.out.print(var + ".");
            }
            System.out.println();

            System.out.println("Proposez un mot :");
            mot = sc.nextLine();
            motValide = Outils.motValide(mot, tirage);

            if (!motValide) {
                System.out.println(ERREUR+ "Le mot n'est pas valide. Veuillez proposer un autre mot." + ERREUR_RESET);
            }

        } while (!motValide);

        System.out.println("Quel sens souhaitez-vous, répondez 0 pour Horizontal ou 1 pour Vertical ? Le premier mot doit être placé au centre.");
        sens = sc.nextInt();
        Plateau.placementMot("H", 8, sens, mot); // Placement en case H8

        // Afficher les points après le premier tour
        points = Outils.bonusCase(joueurs[0], mot,7, 7, sens,  tirage, sachet);

        System.out.println("Points du joueur :");
        System.out.println("Joueur " + joueurs[0] + ": " + points + " points");
        System.out.println();

    }

    public static void tourDeJeu(String joueur, String[][][] sachet,String[] joueurs ) {

        String mot;
        boolean motValide;
        int sens;
        String ligne;
        int colonne;
        int points=0;

        System.out.println("Voici votre chevalet " + joueur + " :");
        char[] tirage = Outils.premierTirage(sachet, joueur);

        for (char var : tirage) {
            System.out.print(var + ".");
        }
        System.out.println();

        int passerSonTour = Outils.passerSonTour(joueur, joueurs);

        if (passerSonTour == 0) {
            do {
                System.out.println("Proposez un mot :");
                mot = sc.next();
                System.out.println("Où souhaitez-vous placer la première lettre ?");
                System.out.print("Ligne:");
                ligne = sc.next().toUpperCase();
                System.out.print("Colonne:");
                colonne = sc.nextInt();

                System.out.println("Quel sens souhaitez-vous, répondez 0 pour Horizontal ou 1 pour Vertical ?");
                sens = sc.nextInt();
                motValide = Outils.motValide(mot, tirage);

                if (!motValide) {
                    System.out.println(ERREUR+ "Le mot n'est pas valide. Que souhaitez-vous faire ? (1. Proposer un autre mot / 2. Passer son tour)" + ERREUR_RESET);
                    int choixMot = sc.nextInt();
                    if (choixMot == 2) {
                        break; // Sort de la boucle de proposition de mot
                    }
                }
            } while (!motValide);

            if (motValide) {

                int Intligne = (int) ligne.charAt(0) - (int) 'A';
                points += Outils.bonusCase(joueur, mot, Intligne, colonne, sens,  tirage, sachet);

                if (Plateau.caseEstVide(Intligne, colonne)) {
                    Plateau.placementMot(ligne, colonne, sens, mot);
                } else {
                    System.out.println(ERREUR+ "La case n'est pas vide" + ERREUR_RESET);
                }

            }
            Outils.dictionnaire();

            System.out.println("Points du joueur :");
            System.out.println("Joueur " + joueur + ": " + points + " points");
            System.out.println();

        }
    }



}