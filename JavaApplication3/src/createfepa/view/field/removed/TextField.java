/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.view.field.removed;

import createfepa.framework.Field;
import javax.swing.JTextField;


public class TextField extends Field {
public JTextField inputField;
public int ncaratteri;
    public TextField(String nome_campo,boolean obbligatorieta,int ncaratteri) {
        super();
        this.setTipo_campo("text");
        this.ncaratteri = ncaratteri;
        
    }

    public TextField() {
        
    }
    public JTextField newTextField(){
  this.inputField = new JTextField(this.ncaratteri);
  inputField.setEditable(true);
  this.inputField.setName(this.getNome_campo());
  
return this.inputField;
    }
    
    
    
}
