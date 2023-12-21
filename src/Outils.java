import java.util.*;
import java.io.*;
public class Outils {

    public static List<Character> sachets(){

        List<Character> sachet = new ArrayList<>();

        String lettres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int[] frequences = {9, 2, 2, 3, 15, 2, 2, 2, 8, 1, 1, 5, 3, 6, 6, 2, 1, 6, 6, 6, 6, 2, 1, 1, 1, 1};

        for (int i = 0; i < lettres.length(); i++) {
            char lettre = lettres.charAt(i);
            int frequence = frequences[i];


            for (int j = 0; j < frequence; j++) {
                sachet.add(lettre);
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
            File fichier = new File("./src/dico/dicoScrabble");

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


    public static boolean motValide(String mot){

        return dico.contains(mot.toLowerCase());
    }

    public static void retraitLettresJouées(char lettre,char[] tirageLettre){
        //Enregistre l'historique des lettres jouer

        char[] lettrejoue = new char[102];
        int i;
        int j=0;

        for(i=0;i<tirageLettre.length;i++){
            if(lettre == tirageLettre[i]){
                lettrejoue[j]=lettre;
                j++;
                tirageLettre[i]='0';
            }
        }

    }

    public static char[] premierTirage(char[] sachet,int joueur){

        int i ;
        char[] lettreTirée = new char[7];
        for(int j = 0; j<7;j++){
            i=(int) Math.random() * 101;
            lettreTirée[j]=sachet[i];
            sachet[i]='0';
        }
        return lettreTirée;
    }

   // public static char[] tirage(char[] sachet,int tour){

    //}

    public static int nbPoints(int joueur,char lettre){

        return joueur;
    }




    public static void main(String[] args){
        dictionnaire();
        System.out.println(motValide("Javax"));
        System.out.println(motValide(""));
        System.out.println(motValide("java"));
        System.out.println(motValide("titre"));
    }


}