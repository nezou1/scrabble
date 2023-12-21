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

        return dico.contains(mot.toUpperCase());
    }

    public static void historiqueLettres(char lettre,char[] sachet){
        //Enregistre l'historique des lettres jouer

        char[] lettrejoue = new char[102];
        int i;
        int j=0;

        for(i=0;i<sachet.length;i++){
            if(lettre == sachet[i]){
                lettrejoue[j]=lettre;
                j++;
                sachet[i]='0';
            }
        }

    }

    public static void main(String[] args){
        dictionnaire();
        System.out.println(motValide("Javax"));
        System.out.println(motValide(""));
        System.out.println(motValide("JAVA"));

    }


}