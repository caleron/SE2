/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.beobachter;

/**
 * @author 3meins
 *
 */
public class BeobachterTestKlasse implements Beobachter
{
    private int counter = 0;
    
    @Override
    public void reagiereAufAenderung(Beobachtbar werkzeug)
    {
        // TODO Auto-generated method stub
        counter++;
    }
    
    public int getCounter()
    {
        return counter;
    }
    
}
