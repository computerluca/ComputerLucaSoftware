/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createpa.model.validation;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author luca
 */
public class VerifyPartitaIva extends InputVerifier {
         @Override
         public boolean verify(JComponent input) {
             JTextField tf = (JTextField) input;
             return "pass".equals(tf.getText());
         }
}
