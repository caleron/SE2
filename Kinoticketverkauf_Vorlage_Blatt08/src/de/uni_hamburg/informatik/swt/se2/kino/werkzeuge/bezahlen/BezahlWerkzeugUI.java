/**
 * 
 */
package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlen;

import java.awt.*;
import java.awt.Dialog.ModalityType;

import javax.swing.*;

/**
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
        _restBetragTextField = new JTextField();
        
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
    
    public JButton gibOKButton()
    {
        return _okButton;
    }
    
    public JButton gibAbbrechenButton()
    {
        return _abbrechenButton;
    }
    
    public JTextField gibZuBezahlenTextField()
    {
        return _zuBezahlenTextField;
    }
    
    public JTextField gibBezahltTextField()
    {
        return _bezahltTextField;
    }
    
    public JTextField gibRestBetragTextField()
    {
        return _restBetragTextField;
    }
    
    public JDialog gibDialog()
    {
        return _bezahlDialog;
    }
    
}
