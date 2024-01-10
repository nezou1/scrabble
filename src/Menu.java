import java.awt.*;
import java.util.Scanner;

public class Menu {

    public static void menu() {

        Scanner sc = new Scanner(System.in);


        int choixConverti;
        String choix;
        do {
            do {
                System.out.println("Bienvenue sur le jeu Scrabble ! ");
                System.out.println("1. Jouer ");
                System.out.println("2. Règles du jeu");
                System.out.println("3. Quitter");
                System.out.println("Veuillez saisir votre choix: ");
                choix = sc.nextLine();
                System.out.println();
            } while (choix.length() != 1);
            choixConverti = (choix.charAt(0) - 48);
        } while (choixConverti != 3 && choixConverti != 2 && choixConverti != 1);


        int nb = 0;
        switch (choixConverti) {
            case 1:
                Partie.demarrerLaPartie();
            case 2:
                reglesDuJeu();
                break;

            case 3:
                System.out.println("A bientôt :)");
                return;
        }
    }

    public static void reglesDuJeu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Les règles du Scrabble peuvent varier légèrement d'un pays à l'autre, mais voici les règles générales pour le jeu de Scrabble en français :\n" +
                "\n" +
                "1. **Le Plateau de Jeu :**  \n Le jeu se déroule sur un plateau de 15x15 cases. Chaque case a une lettre et une valeur qui indique le nombre de points que vaut une lettre posée dessus.\n" +
                "\n" +
                "2. **Les Lettres et leur Valeur :**\n" +
                "   - Chaque joueur commence avec un support de lettres tirées au hasard.\n" +
                "   - Chaque lettre a une valeur en points.\n" +
                "   - Le J, le K, le Q, le X, le Y, et le Z valent 10 points.\n" +
                "   - Les autres lettres ont des valeurs de 1 à 9 points.\n" +
                "\n" +
                "3. **Formation des Mots :**\n" +
                "   - Les mots sont formés en plaçant les lettres sur le plateau de jeu.\n" +
                "   - Les mots peuvent être formés horizontalement ou verticalement.\n" +
                "   - Un mot doit utiliser au moins une lettre déjà posée sur le plateau.\n" +
                "   - Les mots doivent être des mots valides de la langue utilisée.\n" +
                "\n" +
                "4. **Bonus de Case :**\n" +
                "   - Certains cases du plateau offrent des bonus de points : lettre double, lettre triple, mot double, mot triple.\n" +
                "   - Si une lettre est placée sur une case de lettre double, sa valeur est doublée.\n" +
                "   - Si une lettre est placée sur une case de lettre triple, sa valeur est triplée.\n" +
                "   - Si un mot couvre une case de mot double, le score du mot est doublé.\n" +
                "   - Si un mot couvre une case de mot triple, le score du mot est triplé.\n" +
                "\n" +
                "5. **Le Premier Mot :** Le premier mot doit être placé de manière à couvrir la case centrale du plateau.\n" +
                "\n" +
                "6. **Tour suivant :**\n" +
                "   - Les joueurs peuvent échanger certaines de leurs lettres s'ils le souhaitent, mais cela compte comme un tour.\n" +
                "   - Le joueur doit piocher de nouvelles lettres pour remplacer celles échangées.\n" +
                "\n" +
                "7. **Fin de la Partie :**\n" +
                "   - La partie se termine lorsqu'un joueur a épuisé toutes ses lettres et que le sac de lettres est vide, ou lorsque tous les joueurs passent consécutivement.\n" +
                "\n" +
                "8. **Calcul du Score :**\n" +
                "   - Le score d'un tour est la somme des valeurs des lettres utilisées, en tenant compte des bonus de cases spéciales.\n" +
                "\n" +
                "9. **Décompte Final :**\n" +
                "   - En fin de partie, les joueurs décomptent le total de leurs points en fonction des lettres non utilisées sur leur support, en déduisant leur valeur en points.\n" +
                "\n" +
                "10. **Gagnant :** Le joueur avec le score le plus élevé à la fin de la partie est le gagnant.\n" +
                "\n" +
                "Ces règles sont basées sur le Scrabble en français. Si vous jouez dans une autre langue, les valeurs des lettres et certaines règles spécifiques peuvent différer.\n");

        System.out.println("Voulez-vous continuer ? (o : oui /n : non)");
        String choix2 = sc.nextLine();

        if (choix2.equals("o")) {
            menu();
        }
    }
}