/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;

/**
 * @author 3buchhar
 *
 */
public class BezahlWerkzeug
{
    BezahlWerkzeugUI _ui; 

    private boolean _okGeklickt;
    private int _preis;
    /**
     * Initialisiert das BezahlWerkzeug.
     */
    public BezahlWerkzeug()
    {
        _ui = new BezahlWerkzeugUI();
        registriereUIAktionen();
    }
    
    private void registriereUIAktionen()
    {

        MouseAdapter listener = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent arg0)
            {
                _okGeklickt = arg0.getComponent().equals(_ui.gibOKButton());
                
                _ui.gibDialog().setVisible(false);
            }
        };
        
        _ui.gibOKButton().addMouseListener(listener);
        _ui.gibAbbrechenButton().addMouseListener(listener);
        
        _ui.gibBezahltTextField().addKeyListener(new KeyAdapter()
        {

            @Override
            public void keyReleased(KeyEvent e)
            {
                try
                {
                    int bezahlt = Integer.parseInt(_ui.gibBezahltTextField().getText());
                    
                    _ui.gibOKButton().setEnabled(_preis <= bezahlt);
                    
                } 
                catch (Exception ex) 
                {
                    _ui.gibOKButton().setEnabled(false);
                }
                
            }
        });
        
    }

    public boolean zeigeFenster(int preis)
    {
        _preis = preis;
        _ui.gibOKButton().setEnabled(false);
        
        System.out.println("halt");
        
        _ui.gibZuBezahlenTextField().setText(Integer.toString(preis));
        
        _ui.gibDialog().setVisible(true);
        
        System.out.println("weiter");
        return _okGeklickt;
    }
}
