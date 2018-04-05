
public class Videospiel implements Medium
{
	
	private String _titel;
	private String _system;
	private String _kommentar;
	
	/*
	private String _entwickler;
	private int _fsk;*/
	
    /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel des Videospiels
     * @param kommentar Ein Kommentar zum Videospiel
     * @param fsk FSK des Videospiels
     * @param entwickler Entwickler des Videospiels
     * 
     * @require titel != null
     * @require kommentar != null
     * @require system != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     * @ensure getSystem() == system
     */
    public Videospiel(String titel, String kommentar, String system)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        assert system != null : "Vorbedingung verletzt: system != null";
      
        _titel = titel;
        _kommentar = kommentar;    	
    	_system = system;
    /*	_fsk = fsk;    
    	_entwickler = entwickler;*/

        
    }
    /**
     * Gibt den Kommentar zum Videospiels zurück.
     * 
     * @return Den Kommentar des Videospiels.
     * 
     * @ensure result != null
     */
	@Override
	public String getKommentar()
	{		
		return _kommentar;
	}
	 /**
     * Gibt die Medienbezeichnung zurück.
     * 
     * @return Die Bezeichnung des Mediums.
     * 
     * @ensure result != null
     */
	@Override
	public String getMedienBezeichnung()
	{		
		return "Videospiel";
	}

    /**
     * Gibt den Titel des Videospiels zurück.
     * 
     * @return Den Titel des Videospiels.
     * 
     * @ensure result != null
     */
	@Override
	public String getTitel()
	{
		return _titel;
	}

    /**
     * Gibt das system des Videospiels zurück.
     * 
     * @return Das system des Videospiels
     * 
     * @ensure result != null
     */
	public String getSystem()
	{
		return _system;
	}
	
	 /**
     * Gibt Alle Eigenschaften des Videospiels zurück.
     * 
     * return alle Eigenschaften des Videospiels
     * 
     * @ensure result != null     * 
     * 
     * */
	@Override
	public String getFormatiertenString()
	{
		return String.format("Titel: %s , Kommentar: %s, System: %s , Medium: %s", _titel , _kommentar , _system , getMedienBezeichnung());
	}

    /**
     * Gibt die Entwickler des Videospiels zurück.
     * 
     * @return Die Entwickler des Videospiels
     * 
     * @ensure result != null
     */
	/*
	public String getEntwickler()
	{
		return _entwickler;
	}*/


    /**
     * Gibt das FSK des Videospiels zurück.
     * 
     * @return Den FSK des Videospiels
     * 
     * @ensure result != null
     *//*
	public int getFsk()
	{
		return _fsk;
	}*/


}
