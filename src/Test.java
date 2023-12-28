public class Test {

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

    public static void main(String[] args) {

        String[][][] sachet = sachets();

        for (int i = 0; i < sachet.length; i++) {
            for (int j = 0; j < sachet[i].length; j++) {
                for (int k = 0; k < sachet[i][j].length; k++) {
                    System.out.print(sachet[i][j][k] + " ");
                }
                System.out.println(); // Nouvelle ligne entre chaque j
            }
        }
    }


}
