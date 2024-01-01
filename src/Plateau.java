import java.awt.*;

public class Plateau {

    public static Color rouge = new Color(255, 0, 0);
    public static Color bleuPastel = new Color(173, 216, 230);
    public static Color bleuFonce = new Color(54, 122, 240);
    public static Color rose = new Color(255, 182, 193);
    public static Color blanc = new Color(255, 255, 255);

    public static char[][] plateau = new char[15][15];

    public static char[][] afficherPlateauVide() {
        Color[][] couleurs = new Color[15][15];


        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                plateau[i][j] = ' ';
                couleurs[i][j] = determinerCouleurCase(i, j);
            }
        }

        afficherCase(' ', rouge);
        System.out.print(": Mot triple \t");
        afficherCase(' ', rose);
        System.out.print(": Mot Double \t");
        afficherCase(' ', bleuFonce);
        System.out.print(": Lettre triple \t");
        afficherCase(' ', bleuPastel);
        System.out.print(": Lettre double \t");

        System.out.println("\n");

        System.out.println("     1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");
        System.out.println("  ---------------------------------------------------------------------------");
        for (int i = 0; i < 15; i++) {
            System.out.print((char) ('A' + i) + " |");
            for (int j = 0; j < 15; j++) {
                afficherCase(plateau[i][j], couleurs[i][j]);  // Utilisation de la méthode afficherCase avec couleur
            }
            System.out.print(" " + (char) ('A' + i));
            System.out.println();
            System.out.println("  ----------------------------------------------------------------------------");
        }
        System.out.println("     1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");

        return plateau;
    }

    public static char[][] placementMot(String ligne, int colonne, int sens, String mot) {
        int indexLigne = ligne.charAt(0) - 'A';
        int indexColonne = colonne - 1;
        String motMaj = mot.toUpperCase();

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                if (i == indexLigne && j == indexColonne) {
                    if (Plateau.plateau[indexLigne][indexColonne + 1] != ' ') {

                        System.out.println("Cette case est déja prise");

                    } else {
                        if (sens == 0) { // Horizontal
                            if (Plateau.plateau[indexLigne][indexColonne + 1] == ' ')
                                for (int k = 0; k < mot.length(); k++) {
                                    Plateau.plateau[indexLigne][indexColonne + k] = motMaj.charAt(k);
                                    i++;
                                }
                            }
                        }if (sens == 1) { // Vertical
                            if (Plateau.plateau[indexLigne + 1][indexColonne] == ' ')
                                for (int k = 0; k < mot.length(); k++) {
                                    Plateau.plateau[indexLigne + k][indexColonne] = motMaj.charAt(k);
                                    i++;
                                }
                            }
                        }

            }
        }





        Plateau.afficherCase(' ', Plateau.rouge); System.out.print(": Mot triple \t");
        Plateau.afficherCase(' ', Plateau.rose); System.out.print(": Mot Double \t");
        Plateau.afficherCase(' ', Plateau.bleuFonce); System.out.print(": Lettre triple \t");
        Plateau.afficherCase(' ', Plateau.bleuPastel); System.out.print(": Lettre double \t");

        System.out.println("\n");

        System.out.println("     1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");
        System.out.println("  ---------------------------------------------------------------------------");
        for (int i = 0; i < 15; i++) {
            System.out.print((char) ('A' + i) + " |");
            for (int j = 0; j < 15; j++) {
                Plateau.afficherCase(Plateau.plateau[i][j], Plateau.determinerCouleurCase(i,j));  // Utilisation de la méthode afficherCase avec couleur
            }
            System.out.print(" "+ (char)('A' + i));
            System.out.println();
            System.out.println("  ----------------------------------------------------------------------------");
        }
        System.out.println("     1    2    3    4    5    6    7    8    9    10   11   12   13   14   15");

        return Plateau.plateau;
    }

    public static int[] coordonneeSymetrique(int x, int y) {
        int[] symmetricCoordinates = new int[2];
        symmetricCoordinates[0] = 14 - x;
        symmetricCoordinates[1] = y;
        return symmetricCoordinates;
    }

    public static Color determinerCouleurCase(int ligne, int colonne) {
        int[] symmetricCoordinates = coordonneeSymetrique(colonne, ligne);

        int symmetricLigne = symmetricCoordinates[1];
        int symmetricColonne = symmetricCoordinates[0];

        if ((ligne > 0 && ligne < 5) || (ligne > 9 && ligne < 14)) {
            if (ligne == colonne || symmetricLigne == symmetricColonne) {
                return rose; // Rose pastel
            }
        }

        if (ligne == 0 || ligne == 7 || ligne == 14) {
            if (colonne == 0 || colonne == 7 || colonne == 14
                    || symmetricColonne == 0 || symmetricColonne == 7 || symmetricColonne == 14) {
                return rouge; // Rouge
            }
        }

        if ((ligne == 5 || ligne == 9) || (symmetricLigne == 5 || symmetricLigne == 9)) {
            if ((colonne == 1 || colonne == 5 || colonne == 9 || colonne == 13)
                    || (symmetricColonne == 1 || symmetricColonne == 5 || symmetricColonne == 9 || symmetricColonne == 13)) {
                return bleuFonce;
            }
        }

        if ((colonne == 5 || colonne == 9) || (symmetricColonne == 5 || symmetricColonne == 9)) {
            if ((ligne == 1 || ligne == 5 || ligne == 9 || ligne == 13)
                    || (symmetricLigne == 1 || symmetricLigne == 5 || symmetricLigne == 9 || symmetricLigne == 13)) {
                return bleuFonce;
            }
        }

        if (ligne == 0 || ligne == 7 || ligne == 14) {
            if (colonne == 3  || symmetricColonne == 3 ) {
                return bleuPastel; //
            }
        }

        if (ligne == 3 || ligne == 11 ) {
            if (colonne == 0  || colonne == 7 || symmetricColonne == 0 || symmetricColonne == 7 ) {
                return bleuPastel; //
            }
        }

        if (ligne == 6 || ligne == 8 ) {
            if (colonne == 2  || colonne == 6 || symmetricColonne == 2 || symmetricColonne == 6 ) {
                return bleuPastel; //
            }
        }

        if (ligne == 2 || ligne == 6 || ligne == 8 || ligne == 12 ) {
            if (colonne == 6  ||  symmetricColonne == 6  ) {
                return bleuPastel; //
            }
        }

        return blanc;
    }


    public static void afficherCase(char lettre, Color couleur) {

        System.out.print(" \u001B[48;2;" + couleur.getRed() + ";" + couleur.getGreen() + ";" + couleur.getBlue() + "m " + " \u001B[38;2;0;0;0m" + lettre  + " \u001B[0m");

    }



}

