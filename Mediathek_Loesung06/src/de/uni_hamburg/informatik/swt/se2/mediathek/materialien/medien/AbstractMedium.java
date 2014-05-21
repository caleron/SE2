package de.uni_hamburg.informatik.swt.se2.mediathek.materialien.medien;

import java.util.ArrayList;
import java.util.List;

import de.uni_hamburg.informatik.swt.se2.mediathek.fachwerte.Geldbetrag;
import de.uni_hamburg.informatik.swt.se2.mediathek.materialien.Kunde;

/**
 * Ein AbstractMedium bietet eine Standardimplementation für ein Medium an.
 * 
 * @author SE2-Team
 * @version SoSe 2014
 */
abstract class AbstractMedium implements Medium
{
    // 4 Leerzeichen für formatierte Strings
    protected static final String SPACE = "    ";

    /**
     * Gebühr für einen Tag
     */
    private final int _tagesmietgebuehr;

    /**
     * Ein Kommentar zum Medium
     */
    private String _kommentar;

    /**
     * Der Titel des Mediums
     * 
     */
    private String _titel;

    /**
     * Die Liste aller Vormerker.
     */
    List<Kunde> _vormerker = new ArrayList<Kunde>();
    
    /**
     * Initialisiert ein neues Exemplar.
     * 
     * @param titel Der Titel des Mediums
     * @param kommentar Ein Kommentar zum Medium
     * 
     * @require titel != null
     * @require kommentar != null
     * 
     * @ensure getTitel() == titel
     * @ensure getKommentar() == kommentar
     */
    public AbstractMedium(String titel, String kommentar)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _titel = titel;
        _kommentar = kommentar;
        _tagesmietgebuehr = 300;
    }

    @Override
    public Geldbetrag berechneMietgebuehr(int mietTage)
    {
        assert mietTage > 0 : "Vorbedingung verletzt: mietTage > 0";

        return new Geldbetrag(_tagesmietgebuehr * mietTage);
    }

    @Override
    public String getFormatiertenString()
    {
        return getMedienBezeichnung() + ":\n" + SPACE + "Titel: " + _titel
                + "\n" + SPACE + "Kommentar: " + _kommentar + "\n";
    }

    @Override
    public String getKommentar()
    {
        return _kommentar;
    }

    /**
     * Ändert den Kommentar
     * 
     * @param kommentar Ein Kommentar zum Medium
     * 
     * @require kommentar != null
     * @ensure getKommentar() == kommentar
     */
    public void setKommentar(String kommentar)
    {
        assert kommentar != null : "Vorbedingung verletzt: kommentar != null";
        _kommentar = kommentar;
    }

    @Override
    public String getTitel()
    {
        return _titel;
    }

    /**
     * Ändert den Titel
     * 
     * @param titel Der Titel des Mediums
     * 
     * @require titel != null
     * @ensure getTitel() == titel
     */
    public void setTitel(String titel)
    {
        assert titel != null : "Vorbedingung verletzt: titel != null";
        _titel = titel;
    }

    /**
     * Gibt die anzahl der Vormerker zurück.
     * @return Anzahl Vormerker
     */
    public int gibAnzahlVormerker()
    {
        return _vormerker.size();
    }
    
    /**
     * Gibt den ersten Vormerker zurück.
     * @return der erste Vormerker
     * @require gibAnzahlVormerker > 0
     * @ensure kunde != null
     */
    public Kunde gibErstenVormerker()
    {
        assert gibAnzahlVormerker() > 0 : "Vorbedingung verletzt: gibAnzahlVormerker() > 0"; 
        
        return _vormerker.get(0);
    }
    
    /**
     * Prüft, ob ein Vormerkerplatz frei ist.
     * @return Vormerkerplatz frei?
     */
    public boolean vormerkerPlatzFrei()
    {
        return _vormerker.size() < 3;
    }
    
    /**
     * Entfernt den ersten Vormerker
     * @require gibAnzahlVormerker > 0
     */
    public void entferneErstenVormerker()
    {
        assert gibAnzahlVormerker() > 0 : "Vorbedingung verletzt: gibAnzahlVormerker() > 0"; 
        _vormerker.remove(0);
    }
    
    /**
     * Gibt eine Liste der Vormerker zurück.
     * @return die Liste der Vormerker
     */
    public List<Kunde> gibVormerker()
    {
        return _vormerker;
    }
    
    /**
     * Fügt einen Vormerker hinzu.
     * @param kunde Der vormerkende Kunde
     * @require gibAnzahlVormerker() < 3
     * @require kunde != null
     */
    public void fuegeVormerkerHinzu(Kunde kunde)
    {
        assert kunde != null : "Vorbedingung verletzt: kunde != null";
        assert gibAnzahlVormerker() < 3 : "Vorbedingung verletzt: gibAnzahlVormerker() < 3"; 
        
        _vormerker.add(kunde);
    }
    
    /**
     * Prüft, ob das Medium vorgemerkt ist.
     * @return Ist Vorgemerkt?
     */
    public boolean istVorgemerkt()
    {
        return _vormerker.size() > 0;
    }


    /**
     * entfernt einen Kunden von der Liste der Vormerker
     * @param kunde Der Kunde
     */
    public void entferneVormerker(Kunde kunde)
    {

        assert gibAnzahlVormerker() > 0 : "Vorbedingung verletzt: gibAnzahlVormerker() > 0"; 

        _vormerker.remove(kunde);
    }
}
