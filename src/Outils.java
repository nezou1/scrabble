import java.util.*;
public class Outils {

    public static void sachet(){

        int i;
        char[] sachet = new char[102];

        for(i=0;i<)
    }

    private static Set<String> dico;
    public static void dictionnaire(){

        // Initialise le dictionnaire avec quelques mots de démonstration
        dico = new HashSet<>();
        dico.add("JAVA");
        dico.add("SCRABBLE");
        dico.add("PROGRAMMING");


    }

    public static boolean motValide(String mot){
        return dico.contains(mot.toUpperCase());
    }

    public static void historiqueLettres(char lettre){
        //Enregistre l'historique des lettres jouer

        char[] tab = new char[102];
        int i;

        for(i=0; i< tab.length;i++){
            tab[i]=lettre;
        }
    }

    public static void main(String[] args){
        dictionnaire();
        System.out.println(motValide("Javax"));
        System.out.println(motValide(""));
        System.out.println(motValide("JAVA"));

    }


}