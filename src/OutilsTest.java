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

        int points = Outils.nbPoints(joueur, "BAC", tirage, sachet);
        assertEquals(7, points);

        int points2 = Outils.nbPoints(joueur, "feg", tirage, sachet);
        assertEquals(0, points2);

    }

}

