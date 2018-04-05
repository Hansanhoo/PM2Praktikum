

import java.util.List;

import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

/**
 * Ein MedienDetailAnzeigerWerkzeug ist ein Werkzeug um die Details von Medien
 * anzuzeigen.
 * 
 * @author SE2-Team, PM2-Team
 * @version SoSe 2018
 */
class MedienDetailAnzeigerWerkzeug
{
    private MedienDetailAnzeigerUI _ui;

    /**
     * Initialisiert ein neues MedienDetailAnzeigerWerkzeug.
     */
    public MedienDetailAnzeigerWerkzeug()
    {
        _ui = new MedienDetailAnzeigerUI();
    }

    /**
     * Setzt die Liste der Medien deren Details angezeigt werden sollen.
     * 
     * @param medien Eine Liste von Medien.
     * 
     * @require (medien != null)
     */
    public void setMedien(List<Medium> medien)
    {
        assert medien != null : "Vorbedingung verletzt: (medien != null)";
        TextArea selectedMedienTextArea = _ui.getMedienAnzeigerTextArea(); 
        selectedMedienTextArea.setText("");
        
        String titel;
        String kommentar;
        String bezeichnung;
        String showMe ="";
        
        //Man braucht kein InstanceOf mehr, da m weiß welches Medium es ist und dynamisch in die jeweilige Klasse geht und dort die Methode getFormatiertenString aufruft. 
        //Da m ein Medium ist und alle Klasen die ein Medium sind das Interface Medium implementiert haben ist auch sicher gestellt, dass es in m die Methode getFormatiertenString() gibt.
        for(Medium m : medien) {        	
        	//+= alle die ausgewählt sonst nur jeweiliges => ich fand alle sinnvoller !daher +=!        	
        	showMe += m.getFormatiertenString() +"\n\n";        	
        }
        selectedMedienTextArea.setText(showMe);
       
    }
    /*
     * if(m instanceof CD) {
        		CD cd = (CD) m;
        		
        		titel = cd.getTitel();
        		kommentar = cd.getKommentar();
        		bezeichnung = cd.getMedienBezeichnung();
        		String interpret = cd.getInterpret();
        		int spiellaenge = cd.getSpiellaenge();
        		
        		showMe = "Titel : " + titel + "\n Kommentar : " + kommentar + "\n Interpret : " +interpret + "\n Länge : " + spiellaenge + "\n Art : " +bezeichnung +"\n\n ";
        		selectedMedienTextArea.setText(showMe);
        	}
        	else if(m instanceof DVD) {
        		DVD dvd = (DVD) m;
        		
        		titel = dvd.getTitel();
        		kommentar = dvd.getKommentar();
        		bezeichnung = dvd.getMedienBezeichnung();
        		String regissseur = dvd.getRegisseur();
        		int laufzeit = dvd.getLaufzeit();
        		
        		showMe = "Titel : " + titel + " Kommentar : " + kommentar + " Regissseur : " + regissseur + " Länge : " + laufzeit + " Art : " +bezeichnung +"\n";
        		selectedMedienTextArea.setText(showMe);
        	}
        	else if(m instanceof Videospiel) {
        		Videospiel videospiel = (Videospiel) m;        	
        		
        		titel = videospiel.getTitel();
        		kommentar = videospiel.getKommentar();
        		bezeichnung = videospiel.getMedienBezeichnung();
        		String system = videospiel.getSystem();
        		
        		showMe = "Titel : " + titel + " Kommentar : " + kommentar + " System : " +system +  " Art : " +bezeichnung +"\n";
        		selectedMedienTextArea.setText(showMe);
        		
        	}
     * 
     * */

    /**
     * Gibt das Panel dieses Subwerkzeugs zurück.
     * 
     * @ensure result != null
     */
    public Pane getUIPane()
    {
        return _ui.getUIPane();
    }
}
