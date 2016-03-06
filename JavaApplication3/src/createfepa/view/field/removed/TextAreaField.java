/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.view.field.removed;

import createfepa.framework.Field;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luca
 */
public class TextAreaField extends JTextArea {
    public JTextArea ciao;
public String nome_campo;
public boolean obbligatorieta;
    public TextAreaField( String nome_campo, boolean obbligatorieta) {
        
        super();
        this.nome_campo = nome_campo;
        this.obbligatorieta= obbligatorieta;
    }

   
    public JTextArea nuova_area_testo(){
         this.ciao = new JTextArea();
         ciao.setName(this.nome_campo);
  ciao.setEditable(true);
return this.ciao;
    }
    

}
