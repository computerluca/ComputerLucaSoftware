/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.framework;

import javax.swing.JDialog;



/**
 *
 * @author luca
 */
class MessageTest{
    public static void main(String args[]) {
      Message cfem = new Message("E","Ciao");
      JDialog d = cfem.generate_new_message(cfem.message, cfem.type);
        d.setVisible(true);
    }
    
}
