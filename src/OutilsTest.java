import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class OutilsTest {

    String[][][] sachet = Outils.sachets();
    @Test
    public void testMotValide() {
        Outils.dictionnaire();
        char[] tirage = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        assertTrue(Outils.motValide("bac", tirage));
        assertFalse(Outils.motValide("ABCD", tirage));
        assertFalse(Outils.motValide("XYZ", tirage));
    }

    @Test
    public void testPremierTirage() {
        char[] tirage = Outils.premierTirage(sachet, "Joueur1");
        assertNotNull(tirage);
        assertEquals(7, tirage.length);
    }

    @Test
    public void testTirageSuivant() {
        char[] tirage = Outils.tirageSuivant(sachet, "Joueur2");
        assertNotNull(tirage);
        assertEquals(7, tirage.length);
    }

    @Test
    public void testNbPoints() {
        Outils.dictionnaire();
        String joueur = "Joueur3";
        char[] tirage = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        char[] tirage2 = {'A', 'J', 'C', 'O', 'E', 'N', 'B'};

        int points = Outils.nbPoints(joueur, "BAC", tirage, sachet);
        assertEquals(7, points);

        int points1 = Outils.nbPoints(joueur, "ca", tirage2, sachet);
        assertEquals(11, points1);

        points1 = Outils.nbPoints(joueur, "bon", tirage2, sachet);
        assertEquals(16, points1);

        int points4 = Outils.nbPoints(joueur, "je", tirage2, sachet);
        assertEquals(25, points4);


    }

/*    @Test
    public void testBonusCaseSansBonus() {
        String joueur2 = "Alice";
        String mot = "TEST";
        int ligne = 4;
        int colonne = 5;
        int sens = 0; // 0 pour horizontal, 1 pour vertical
        char[] tirageLettre = {'T', 'E', 'S', 'T'};
        int score=0;

        score = Outils.bonusCase(joueur2, mot, ligne, colonne, sens, tirageLettre, sachet);
        assertEquals(4, score);
    }


    //@Test
   /* public void testBonusCaseAvecBonus() {


        String joueur = "Alice";
        String mot = "TESTER";
        int ligne = 1;
        int colonne = 1;
        int sens = 0; // 0 pour horizontal, 1 pour vertical
        char[] tirageLettre = {'T', 'E', 'S', 'T', 'E', 'R', 'X'};

        int score = Outils.bonusCase(joueur, mot, ligne, colonne, sens, tirageLettre, sachet);

        assertEquals(16, score);
    }*/
}
