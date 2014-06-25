/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.*;
/**
 * Die GUI des {@link BezahlWerkzeug}.
 * 
 * @author 3buchhar
 *
 */
public class BezahlWerkzeugUI
{
    private JButton _okButton;
    private JButton _abbrechenButton;
    private JLabel _zuBezahlenLabel;
    private JLabel _bezahltLabel;
    private JLabel _restBetragLabel;
    private JTextField _zuBezahlenTextField;
    private JTextField _bezahltTextField;
    private JTextField _restBetragTextField;
    private JDialog _bezahlDialog;
    
    
    /**
     * Initialisiert die Benutzeroberfläche.
     */
    public BezahlWerkzeugUI()
    {
        _bezahlDialog = new JDialog();
        _okButton = new JButton("OK");
        _abbrechenButton = new JButton("Abbrechen");
        _zuBezahlenLabel = new JLabel("Zu bezahlen:", SwingConstants.CENTER);
        _bezahltLabel = new JLabel("bezahlt:", SwingConstants.CENTER);
        _restBetragLabel = new JLabel("Restbetrag:", SwingConstants.CENTER);
        _zuBezahlenTextField = new JTextField();
        _bezahltTextField = new JTextField();
        _restBetragTextField = new JTextField("Zu wenig bezahlt");
        
        _zuBezahlenTextField.setFocusable(false);
        _restBetragTextField.setFocusable(false);
        
        _bezahlDialog.setLayout(new GridLayout(4, 2, 20, 20));
        
        _bezahlDialog.add(_zuBezahlenLabel);
        _bezahlDialog.add(_zuBezahlenTextField);
        _bezahlDialog.add(_bezahltLabel);
        _bezahlDialog.add(_bezahltTextField);
        _bezahlDialog.add(_restBetragLabel);
        _bezahlDialog.add(_restBetragTextField);
        _bezahlDialog.add(_abbrechenButton);
        _bezahlDialog.add(_okButton);
        
        _bezahlDialog.setTitle("Bezahlen");
        _bezahlDialog.setSize(400, 300);
        _bezahlDialog.setModalityType(ModalityType.APPLICATION_MODAL);
        
    }
    
    /**
     * Liefert den OkButton zurück
     * @return der OKButton
     */
    public JButton gibOKButton()
    {
        return _okButton;
    }
    
    /**
     * Liefert den AbbrechenButton zurück
     * @return der AbbrechenButton
     */
    public JButton gibAbbrechenButton()
    {
        return _abbrechenButton;
    }
    
    /**
     * Liefert das BezahlenTextField zurück
     * @return das BezahlenTextField
     */
    public JTextField gibZuBezahlenTextField()
    {
        return _zuBezahlenTextField;
    }
    
    /**
     * Liefert das bezahltTextField zurück
     * @return das bezahltTextField
     */
    public JTextField gibBezahltTextField()
    {
        return _bezahltTextField;
    }
    
    /**
     * Liefert das RestbetragTextfield zurück
     * @return das RestbetragTextfield
     */
    public JTextField gibRestBetragTextField()
    {
        return _restBetragTextField;
    }
    
    /**
     * Liefert den Dialog zurück
     * @return der Dialog
     */
    public JDialog gibDialog()
    {
        return _bezahlDialog;
    }
    
}
