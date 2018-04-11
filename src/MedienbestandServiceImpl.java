import java.util.ArrayList;
import java.util.List;

/**
 * Ein Medienbestand enthält alle zur Verfügung stehenden Medien. Diese können
 * in den Bestand eingepflegt, gelöscht und verändert werden. Zu einem
 * bestimmten Titel kann es mehrere Medien-Objekte im Bestand geben. So kann
 * z.B. die gleiche CD mehrfach vorhanden sein.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2018
 */
class MedienbestandServiceImpl extends AbstractObservableService
        implements MedienbestandService
{

    /**
     * Eine Liste aller Medien
     */
    private List<Medium> _medienbestand;

    /**
     * Initialisiert einen neuen Medienbestand.
     * 
     * @param medien Der initiale Medienbestand.
     */
    public MedienbestandServiceImpl(List<Medium> medien)
    {
        _medienbestand = new ArrayList<Medium>(medien);
    }
    /**
     * Entfernt ein Medium aus dem Medienbestand, z.B. wenn es verloren gegangen
     * ist oder so veraltet, dass es von den Mediathek-Kunden nicht mehr
     * nachgefragt wird.
     * 
     * @param medium Ein zu entfernendes Medium
     * 
     * @require enthaeltMedium(medium)
     * @require medium !=null
     * 
     * @ensure !enthaeltMedium(medium)
     */
    @Override
    public void entferneMedium(Medium medium)
    {
    	assert enthaeltMedium(medium) : "Vorbedingung verletzt: Dieses Medium gibt es nicht!"; // ??unnötig, da es in enthaeltMedium geprüft wird ??
    	assert medium != null : "Vorbedingung verletzt: Es gibt keine Medium zum entfernen!";
    	
        _medienbestand.remove(medium);

        informiereUeberAenderung();
    }
    /**
     * Gibt Auskunft, ob ein Medium im Medienbestand enthalten ist.
     * 
     * @param medium Ein Medium
     * @return true, wenn Medium im Medienbestand enthalten ist, andernfalls
     *         false.
     *         
     * @require medium !=null
     * 
     * @ensure result != null
     */
    @Override
    public boolean enthaeltMedium(Medium medium)
    {
    	assert medium != null : "Vorbedingung verletzt: Es gibt keine Medium !";
        return _medienbestand.contains(medium);
    }
    /**
     * Fügt ein weiteres, neu angeschafftes Medium in den Bestand ein. Ist ein
     * Medium mehrfach angeschafft worden, so kann es auch mehrfach eingepflegt
     * werden. Jedes Exemplar im Bestand repräsentiert ein real existierendes
     * Medium.
     * 
     * @param neuesMedium Ein neues Medium
     * 
     * @require neusMedium !=null
     * 
     * @ensure enthaeltMedium(neuesMedium)  
     */
    @Override
    public void fuegeMediumEin(Medium neuesMedium)
    {
    	assert neuesMedium != null : "Vorbedingung verletzt: Es gibt keine Medium zum einfügen!";
        _medienbestand.add(neuesMedium);

        informiereUeberAenderung();
    }
    /**
     * Liefert alle vorhandenen Medien.
     * 
     * @return Eine Kopie der Liste mit allen vorhandenen Medien.
     * 
     * @require _medienbestand.size() > 0
     * @ensure result != null
     */
    @Override
    public List<Medium> getMedien()
    {
    	assert _medienbestand.size() > 0 : "Vorbedingung verletzt: Es gibt keine Medien!";
    	
        return new ArrayList<Medium>(_medienbestand);
    }

    @Override
    public void medienWurdenGeaendert()
    {
        informiereUeberAenderung();
    }

}
