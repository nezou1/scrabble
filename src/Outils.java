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