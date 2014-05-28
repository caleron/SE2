package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachter;

/**
 * Beschreibt einen Beobachter.
 *
 */
public interface Beobachter
{
    /**
     * Reagiert auf eine Änderung.
     * @param werkzeug das aufrufende Werkzeug
     */
    void reagiereAufAenderung(Beobachtbar werkzeug);
}
