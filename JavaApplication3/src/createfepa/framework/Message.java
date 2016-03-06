/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.framework;

import static java.util.Collections.enumeration;
import javax.swing.JDialog;

/**
 *
 * @author luca
 */
public class Message {

    /**
     *
     */
    public String type;

    /**
     *
     */
    public String message;
    
    public Message(String t, String m){
        this.type = t;
        this.message = m;
    }
    
    public JDialog generate_new_message(String t,String m){
         JDialog d = new JDialog();
       
       d.setTitle(message);
        d.setName(m);
       d.setVisible(true);
      return d;  
    }
     public JDialog generate_new_error(String t,String m){
         JDialog d = new JDialog();
       
       d.setTitle(message);
        d.setName(m);
       d.setVisible(true);
      return d;  
    }    
    
    
}
