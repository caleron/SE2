package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachter;

import java.util.HashSet;
import java.util.Set;

/**
 * Beschreibt eine beobachtbare Klasse. 
 *
 */
public abstract class Beobachtbar
{
    // die Set von Beobachtern
    private Set<Beobachter> _beobachter = new HashSet<Beobachter>();
    
    /**
     * Fügt einen Beobachter hinzu.
     * @param beobachter
     * @require beobachter != null
     * @ensure _beobachter.contains(beobachter)
     */
    public void fuegeBeobachterHinzu(Beobachter beobachter)
    {
        assert beobachter != null : "Vorbedingung verletzt: beobachter != null";
        
        _beobachter.add(beobachter);
    }
    
    /**
     * Meldet eine Änderung.
     */
    public void meldeAenderung()
    {
        for (Beobachter beobachter : _beobachter)
        {
            beobachter.reagiereAufAenderung(this);
        }
    }
}
