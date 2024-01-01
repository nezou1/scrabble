import java.util.*;
public class Partie {

    public static String[] nbJoueur(){

        String[] joueurs;
        int nbjoueurs;

        Scanner sc = new Scanner(System.in).useDelimiter("\n");

        do{

            System.out.println("4 joueurs maximum est acceptée au Scrabble :)");
            System.out.println("Combien de joueur etes-vous ?");
            nbjoueurs = sc.nextInt();
            joueurs = new String[nbjoueurs];

        }while(nbjoueurs > 4);

        sc.nextLine(); // Ajout de cette ligne pour consommer la nouvelle ligne restante (probleme joueur1)

        for(int i = 0; i < nbjoueurs; i++){

            System.out.print("Veuillez choisir votre pseudo joueur"+(i+1)+": ");
            joueurs[i]= sc.nextLine();
        }

        return joueurs;
    }

}
