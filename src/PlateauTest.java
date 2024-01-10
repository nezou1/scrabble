import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlateauTest {

    @Test
    public void testPlacementMotHorizontal() {

        char[][] plateauAvecMot = Plateau.placementMot("A", 1, 0, "TEST");


        assertEquals('T', plateauAvecMot[0][0]);
        assertEquals('E', plateauAvecMot[0][1]);
        assertEquals('S', plateauAvecMot[0][2]);
        assertEquals('T', plateauAvecMot[0][3]);
        assertEquals(' ', plateauAvecMot[0][4]); // Vérifiez la case suivante est vide
    }

    @Test
    public void testPlacementMotVertical() {
        char[][] plateauAvecMot = Plateau.placementMot("A", 1, 1, "TEST");

        assertEquals('T', plateauAvecMot[0][0]);
        assertEquals('E', plateauAvecMot[0][1]);
        assertEquals('S', plateauAvecMot[0][2]);
        assertEquals('T', plateauAvecMot[0][3]);
        assertEquals(' ', plateauAvecMot[0][4]);
    }

    @Test
    public void testCoordonneeSymetrique() {

        int[] symmetricalCoordinates = Plateau.coordonneeSymetrique(3, 7);

        assertEquals(11, symmetricalCoordinates[0]);
        assertEquals(7, symmetricalCoordinates[1]);

        int[] symmetricalCoordinates2 = Plateau.coordonneeSymetrique(0, 0);

        assertEquals(14, symmetricalCoordinates2[0]);
        assertEquals(0, symmetricalCoordinates2[1]);

    }


    @Test
    public void testCaseEstVide() {
        char[][] plateau =  Plateau.afficherPlateauVide();
        assertTrue(Plateau.caseEstVide(0, 0));

        // Placez un mot sur le plateau
        Plateau.placementMot("A", 1, 0, "TEST");
        assertFalse(Plateau.caseEstVide(0, 0)); // Vérifiez que la case n'est plus vide
    }

    @Test
    public void testPremierMotPlaceAuMilieu() {

        assertTrue(Plateau.premierMotPlaceAuMilieu("TEST", 7,"H"));

        assertFalse(Plateau.premierMotPlaceAuMilieu("TEST", 5,"H")); // Vérifiez avec une colonne différente de 7
        assertFalse(Plateau.premierMotPlaceAuMilieu("", 7,"H")); // Vérifiez avec un mot vide
    }
}
