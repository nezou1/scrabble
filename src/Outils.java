import java.awt.*;
import java.util.*;
import java.io.*;
public class Outils {

    public static String[][][] sachets() {

        /* On a d'abord les lettres, ensuite les points par lettre et pour finir la frequence de lettre */
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
    public static void dictionnaire(){

        // Initialise le dictionnaire avec quelques mots de démonstration
        dico = new HashSet<>();
        try {
            // Spécifiez le chemin du fichier
            File fichier = new File("./src/dico/french");

            // Créez un objet BufferedReader pour lire le fichier
            BufferedReader lecteur = new BufferedReader(new FileReader(fichier));

            // Lisez le fichier ligne par ligne
            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                dico.add(ligne);
            }
            // Fermez le BufferedReader
            lecteur.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean motValide(String mot, char[] tirageLettre) {
        // Convertit le mot en minuscules pour une comparaison insensible à la casse
        String motEnMinuscules = mot.toLowerCase();

        // Vérifie si le mot est dans le dictionnaire
        boolean motDansDico = dico.contains(motEnMinuscules);

        // Vérifie si chaque lettre du mot est présente dans les lettres tirées
        boolean lettresDansTirage = true;
        for (int i = 0; i < mot.length(); i++) {
            char lettre = motEnMinuscules.charAt(i);
            if (!lettresDansTirage(lettre, tirageLettre)) {
                lettresDansTirage = false;
                System.out.println("Votre mot est incorrect !");
                break;
            }
        }

        if(motDansDico && lettresDansTirage){
            System.out.println("Votre mot est accepté !");
        }
        // Renvoie vrai uniquement si le mot est dans le dictionnaire et que toutes les lettres sont dans les lettres tirées
        return motDansDico && lettresDansTirage;
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

            do{
                i = (int) (Math.random() * 25);

            }while(Integer.parseInt(sachet[i][0][2]) < 1);

            lettreTirée[j] = sachet[i][0][0].charAt(0); // Récupère la lettre à partir de l'élément [i][0][0]

            int frequence = Integer.parseInt(sachet[i][0][2]) -1;
            sachet[i][0][2] = String.valueOf(frequence) ;// Marque la lettre comme tirée
        }
        return lettreTirée;
    }



   /*public static char[] tirage(char[] sachet,int tour){

    }*/

    public static int nbPoints(String joueur, String mot, char[] tirageLettre, String[][][] sachet) {
        int nbPoints = 0;

        // Vérifie si le mot est valide
        if (motValide(mot, tirageLettre)) {
            // Calcule le nombre de points pour chaque lettre du mot
            for (int i = 0; i < mot.length(); i++) {

                char lettre = Character.toUpperCase(mot.charAt(i)); // Convertit en majuscules pour correspondre à la casse du sachet

                for (int j = 0; j < sachet.length; j++) {
                    for (int k = 0; k < sachet[i].length; k++) {
                        if(sachet[j][k][0].equals(String.valueOf(lettre))){
                            nbPoints += Integer.parseInt(sachet[j][k][1]);
                            break;

                        }

                    }
                }
            }
        }
        return nbPoints;
    }
    public static char[][] placementMot(String ligne, int colonne, int sens, String mot) {
        int indexLigne = ligne.charAt(0) - 'A';
        int indexColonne = colonne - 1;

        if (sens == 0) { // Horizontal
            for (int i = 0; i < mot.length(); i++) {
                Plateau.plateau[indexLigne][indexColonne + i] = mot.charAt(i);
            }
        } else if (sens == 1) { // Vertical
            for (int i = 0; i < mot.length(); i++) {
                Plateau.plateau[indexLigne + i][indexColonne] = mot.charAt(i);
            }
        } else {
            // Gérer le cas où le sens n'est ni horizontal ni vertical
            System.out.println("Sens invalide. Utilisez 0 pour horizontal ou 1 pour vertical.");
        }

        return Plateau.plateau;
    }







/*    public static void main(String[] args) {
        dictionnaire();
        String[][][] sachet = sachets();
        char[] joueur1 = premierTirage(sachet,1);
        char[] test = {'W','R','E','I','B','O','V'};
        char[] test2 = {'N','R','E','I','B','O','V'};

        System.out.println(nbPoints(1,"BOIRE",test,sachet));
        System.out.println(nbPoints(1,"NOIR",test2,sachet));

    }*/


}