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

        int points = Outils.nbPoints(joueur, "bac", tirage, sachet);
        assertEquals(7, points);

        int points1 = Outils.nbPoints(joueur, "ca", tirage2, sachet);
        assertEquals(4, points1);

        points1 += Outils.nbPoints(joueur, "bon", tirage2, sachet);
        assertEquals(9, points1);

        int points4 = Outils.nbPoints(joueur, "je", tirage2, sachet);
        assertEquals(9, points4);


        int points2 = Outils.nbPoints(joueur, "feg", tirage, sachet);
        assertEquals(0, points2);

    }

}
