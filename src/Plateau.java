//import java.awt.*;

public class Plateau {

    public static void afficherPlateau() {
        char[][] plateau = new char[15][15];
        Color[][] couleurs = new Color[15][15];


        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                plateau[i][j] = ' ';
                couleurs[i][j] = determinerCouleurCase(i, j);
            }
        }


        System.out.println("   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15");
        System.out.println("  -----------------------------------------------------------");
        for (int i = 0; i < 15; i++) {
            System.out.print((char) ('A' + i) + " |");
            for (int j = 0; j < 15; j++) {
                afficherCase(plateau[i][j], couleurs[i][j]);  // Utilisation de la méthode afficherCase avec couleur
            }
            System.out.println();
            System.out.println("  -----------------------------------------------------------");
        }
    }



    private static Color determinerCouleurCase(int ligne, int colonne) {
        if ((ligne + colonne) % 2 == 0) {
            // Rose pastel
            return new Color(255, 182, 193);
        } else if ((ligne + colonne) % 3 == 0) {
            // Bleu pastel
            return new Color(173, 216, 230);
        } else {
            // Rouge
            return new Color(255, 0, 0);
        }
    }



    private static void afficherCase(char lettre, Color couleur) {

        System.out.print(" \u001B[48;2;" + couleur.getRed() + ";" + couleur.getGreen() + ";" + couleur.getBlue() + "m " + lettre + " \u001B[0m|");
    }


}


        //System.out.println();
        //System.out.println("Votre chavelet : |__|__|__|__|__|__|__|");
        //System.out.println();
        //System.out.println("Veuillez piocher 7 lettres.");

    }
}
