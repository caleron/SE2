/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Mit diesem Werkzeug kann bezahlt werden. Dabei wird der Restbetrag dargestellt.
 * 
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
    
    /**
     * Alle Aktionen im Dialog werden registriert. Dabei wird auf die verschiedenen Aktionen unterschiedlich eingegangen
     */
    private void registriereUIAktionen()
    {

        MouseAdapter listener = new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                _okGeklickt = e.getComponent().equals(_ui.gibOKButton());
                
                int bezahlt = 0;
                
                try
                {
                    bezahlt = Integer.parseInt(_ui.gibBezahltTextField().getText());
                } 
                catch (Exception ex)  {}
                
                if((_ui.gibOKButton().isEnabled() && _preis <= bezahlt) || !_okGeklickt)
                {
                	_ui.gibDialog().setVisible(false);
                }
                else if (_ui.gibOKButton().isEnabled() && _preis > bezahlt)
                {
                	_ui.gibOKButton().setEnabled(false);
                }
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
                    
                    int rückgeld = bezahlt - _preis;
                    _ui.gibRestBetragTextField().setText(Integer.toString(Math.abs(rückgeld)));
                    
                    if(rückgeld < 0)
                    {
                    	_ui.gibRestBetragTextField().setText("Zu wenig bezahlt");
                    }
                    
                    
                } 
                catch (Exception ex) 
                {
                    _ui.gibOKButton().setEnabled(false);
                    _ui.gibRestBetragTextField().setText("Zu wenig bezahlt");
                }
                
            }
        });
        
        
        
    }

    /**
     * Zeigt den BezahlDialog
     * 
     * @require preis != 0
     * @param preis
     * @return
     */
    public boolean zeigeFenster(int preis)
    {
    	assert preis != 0 : "Vorbedingung verletzt: preis != 0";
    	_ui.gibDialog().setLocationRelativeTo(null);
        _preis = preis;
        _ui.gibOKButton().setEnabled(false);
        
        _ui.gibZuBezahlenTextField().setText(Integer.toString(preis));
        _ui.gibRestBetragTextField().setText("Zu wenig bezahlt");
        _ui.gibBezahltTextField().setText("");
        _ui.gibBezahltTextField().requestFocus();
        
        _ui.gibDialog().setVisible(true);
        
        return _okGeklickt;
    }
}
