import java.util.*;
import java.io.*;
public class Outils {

    public static char[] sachet() {
        int i;
        char[] sachet = new char[102];

        return sachet;
    }

    private static Set<String> dico;
    public static void dictionnaire(){

        // Initialise le dictionnaire avec quelques mots de démonstration
        dico = new HashSet<>();
        try {
            // Spécifiez le chemin du fichier
            File fichier = new File("dico/dicoScrabble");

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