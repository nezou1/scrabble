import java.awt.*;
import java.util.*;
import java.io.*;

public class Outils {

    static Scanner sc = new Scanner(System.in);

    public static String[][][] sachets() {
        // On a d'abord les lettres, ensuite les points par lettre et pour finir la fréquence de lettre
        String[][][] sachet = new String[26][1][3];

        String lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] points = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 10, 1, 2, 1, 1, 3, 8, 1, 1, 1, 1, 1, 4, 10, 10, 10, 10};
        int[] frequences = {9, 2, 2, 3, 15, 2, 2, 2, 8, 1, 1, 5, 3, 6, 6, 2, 1, 6, 6, 6, 6, 2, 1, 1, 1, 1};

        for (int i = 0; i < lettres.length(); i++) {
            for (int j = 0; j < sachet[i].length; j++) {
                char lettre = lettres.charAt(i);
                int point = points[i];
                int frequence = frequences[i];

                sachet[i][j][0] = String.valueOf(lettre);
                sachet[i][j][1] = String.valueOf(point);
                sachet[i][j][2] = String.valueOf(frequence);
            }
        }

        return sachet;
    }

    private static Set<String> dico;

    public static void dictionnaire() {
        dico = new HashSet<>();
        try {
            // Spécifie le chemin du fichier
            File fichier = new File("./src/dico/french");

            // Créer un objet BufferedReader pour lire le fichier
            BufferedReader lecteur = new BufferedReader(new FileReader(fichier));

            // Lis le fichier ligne par ligne
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                dico.add(ligne);
            }
            // Fermez le BufferedReader
            lecteur.close();
        } catch (IOException e) { // class qui gere les exceptions liées à l'entrée/sortie
            e.printStackTrace();  // Si il y'a une exception, affiche des informations détaillées sur l'exception.
        }
    }

    public static boolean motValide(String mot, char[] tirageLettre) {
        String motEnMinuscules = mot.toLowerCase();

        // Vérifie si le mot est dans le dictionnaire
        boolean motDansDico = dico.contains(motEnMinuscules);

        // Vérifie si chaque lettre du mot est présente dans les lettres tirées
        boolean lettresDansTirage = true;
        for (int i = 0; i < mot.length(); i++) {
            char lettre = motEnMinuscules.charAt(i);
            if (!lettresDansTirage(lettre, tirageLettre)) {
                lettresDansTirage = false;
                break;
            }
        }

        if (motDansDico && lettresDansTirage) {
            System.out.println("Votre mot est accepté!");
        }

        return motDansDico && lettresDansTirage; // Renvoie vrai uniquement si le mot est dans le dictionnaire et que toutes les lettres sont dans les lettres tirées
    }





    private static boolean lettresDansTirage(char lettre, char[] tirageLettre) {
        char lettreMaj = Character.toUpperCase(lettre);
        for (int i = 0; i < tirageLettre.length; i++) {
            if (lettreMaj == tirageLettre[i]) {
                tirageLettre[i] = '0'; // Marque la lettre comme utilisée
                return true;
            }
        }
        return false;
    }

    public static char[] premierTirage(String[][][] sachet, String joueur) {
        char[] lettreTirée = new char[7];
        int i;
        for (int j = 0; j < 7; j++) {
            do {
                i = (int) (Math.random() * 26);
            } while (Integer.parseInt(sachet[i][0][2]) < 1);

            lettreTirée[j] = sachet[i][0][0].charAt(0); // Récupère la lettre à partir de l'élément [i][0][0]
            int frequence = Integer.parseInt(sachet[i][0][2]) - 1;
            sachet[i][0][2] = String.valueOf(frequence); // Marque la lettre comme tirée
        }
        return lettreTirée;
    }

    public static char[] tirageSuivant(String[][][] sachet, String joueur) {
        char[] lettresTirees = new char[7];
        int frequence;
        int indexLettre;

        for (int i = 0; i < 7; i++) {
            char lettre;
            do {
                indexLettre = (int) (Math.random() * 26);

                lettre = sachet[indexLettre][0][0].charAt(0);
                frequence = Integer.parseInt(sachet[indexLettre][0][2]);

            } while (frequence <= 0);

            frequence = Integer.parseInt(sachet[indexLettre][0][2]) - 1;
            sachet[indexLettre][0][2] = String.valueOf(frequence);

            // Ajoute la lettre à la liste des lettres tirées
            lettresTirees[i] = lettre;
        }

        return lettresTirees;
    }

    public static int nbPoints =0;
    public static int nbPoints(String joueur, String mot, char[] tirageLettre, String[][][] sachet) {

        // Calcule le nombre de points pour chaque lettre du mot
        for (int i = 0; i < mot.length(); i++) {

            char lettre = Character.toUpperCase(mot.charAt(i)); // Convertit en majuscules pour correspondre à la casse du sachet

            for(int j = 0; j < sachet.length; j++) {
                for (int k = 0; k < sachet[j].length; k++) {
                    if (sachet[j][k][0].equals(String.valueOf(lettre))) {
                        nbPoints += Integer.parseInt(sachet[j][k][1]);
                    }
                }
            }
        }

        return nbPoints;
    }

    public static int bonusCase(String joueur, String mot, int ligne, int colonne, int direction, char[] tirageLettre, String[][][] sachet) {

        int score = nbPoints(joueur, mot, tirageLettre, sachet); // Calcul du score de base du mot
        System.out.println(score);

        // Vérifier pour chaque lettre du mot si des bonus s'appliquent
        for (int i = 0; i < mot.length(); i++) {
            int caseLigne = ligne + (direction == 1 ? i : 0);
            int caseColonne = colonne + (direction == 0 ? i : 0);
            char lettre = mot.charAt(i);

            // Vérifier la couleur de la case et appliquer les bonus
            Color couleurCase = Plateau.determinerCouleurCase(caseLigne, caseColonne);
            if (couleurCase != Plateau.blanc) {
                int valeurLettre = valeurLettreDansSachet(lettre, sachet);
                score = appliquerBonus(score, valeurLettre, couleurCase);
            }
        }

        return score;
    }

    public static int valeurLettreDansSachet(char lettre, String[][][] sachet) {

        int valeurLettre=0;

        for (int j = 0; j < sachet.length; j++) {
            for (int k = 0; k < sachet[j].length; k++) {
                if (sachet[j][k][0].equals(String.valueOf(lettre))) {
                    valeurLettre = Integer.parseInt(sachet[j][k][1]);

                }
            }
        }
        return valeurLettre;
    }

    public static int appliquerBonus(int score, int valeurLettre, Color couleurCase) {

        if(couleurCase == Plateau.bleuFonce ) {
            return score + 3 * valeurLettre;
        }
        else if(couleurCase == Plateau.rose ) {
            return score * 2;
        }
        else if(couleurCase == Plateau.rouge ) {
            return score * 3;
        }
        else {
            return score + 2 * valeurLettre;
        }
    }



    public static int passesSuccessives = 0;

    public static int passerSonTour(String joueur, String[] joueurs) {
        int nbJoueurs = joueurs.length;
        final int NOMBRE_MAX_PASSES_GLOBALES = nbJoueurs * 3;
        int next;

        System.out.println("Souhaitez vous passer votre tour ? (o : oui /n : non )");

        String passe = sc.nextLine();

        if (passe.equals("o")) {
            next = 1;
            System.out.println(joueur + " a choisi de passer son tour.\n");

            passesSuccessives++; // Si un joueur passe son tour, le compteur est incrémenté

            if (passesSuccessives >= NOMBRE_MAX_PASSES_GLOBALES) {
                // Vérifie si le nombre total de passes successives atteint la limite
                System.out.println("Fin de la partie, nombre maximal de passes successives atteint : " + NOMBRE_MAX_PASSES_GLOBALES);
                System.exit(0); // Termine l'exécution du programme
            }
        } else {
            next = 0;
            System.out.println(joueur + " a choisi de ne pas passer son tour.");
        }

        return next;

    }

    public static void reinitialiserPassesSuccessives() {
        passesSuccessives = 0;
    }

    public static boolean finDePartie(String[][][] sachet) {

        boolean sachetVide = true;
        for (int i = 0; i < sachet.length; i++) {
            if (Integer.parseInt(sachet[i][0][2]) > 0) {
                sachetVide = false;
                break;
            }
        }
        if (sachetVide) {
            System.out.println("Fin de la partie, le sachet est vide.");
        }


        return sachetVide;
    }

 /*   public static void main(String[] args){
        String[][][] sachet = Outils.sachets();
        String joueur = "Alice";
        String mot = "beau";
        int ligne = 0;
        int colonne = 0;
        int sens = 0; // 0 pour horizontal, 1 pour vertical
        char[] tirageLettre = {'T', 'E', 'S', 'T', 'A' ,'B', 'C'};

        int scoremot = nbPoints("Alice", "beau", tirageLettre, sachet);
        System.out.println(scoremot);

        int score = Outils.bonusCase(joueur, mot, ligne, colonne, sens, tirageLettre, sachet);
        System.out.println(score);
    }*/
}