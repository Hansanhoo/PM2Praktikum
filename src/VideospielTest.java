import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VideospielTest
{
	private static final String KOMMENTAR = "Kommentar";
    private static final String TITEL = "Titel";
    private static final String BEZEICHNUNG = "Videospiel";
    private static final int FSK = 18;
    private static final String ENTWICKLER = "EpicGames";
    private static final String SYSTEM = "Computer";
    private Videospiel _videospiel1;
    private Videospiel _videospiel2;

    public VideospielTest()
    {
    	_videospiel1 = getMedium();
    	_videospiel2 = getMedium();
    }

    @Test
    public void testGetMedienBezeichnung()
    {
        String videoSpielBezeichung = BEZEICHNUNG;
        assertEquals(videoSpielBezeichung, _videospiel1.getMedienBezeichnung());
    }

    @Test
    public void testKonstruktor()
    {
        assertEquals(TITEL, _videospiel1.getTitel());
        assertEquals(KOMMENTAR, _videospiel1.getKommentar());
        assertEquals(SYSTEM, _videospiel1.getSystem());
        
    }

    @Test
    /*
     * Von ein und dem selben Videospiel kann es mehrere Exemplare geben, die von
     * unterschiedlichen Personen ausgeliehen werden können.
     */
    public void testEquals()
    {
        assertFalse("Mehrere Exemplare des gleichen Videospiels sind gleich",
        		_videospiel1.equals(_videospiel2));
        assertTrue("Mehrere Exemplare der gleichen DVD sind ungleich",
        		_videospiel1.equals(_videospiel1));
    }

    protected Videospiel getMedium()
    {
        return new Videospiel(TITEL, KOMMENTAR, SYSTEM);
    }
}
