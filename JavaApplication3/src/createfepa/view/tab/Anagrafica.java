/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.view.tab;

import createfepa.framework.Tab;
import createfepa.view.field.removed.TextAreaField;
import createfepa.view.field.removed.TextField;

/**
 *
 * @author luca
 */
public class Anagrafica extends Tab {

    public Anagrafica() {
       
       TextField tf = new TextField();
tf.setNome_campo("Partita IVA");
         add(tf.newTextField());
         
         TextAreaField taf = new TextAreaField("Scrivi qui la descrizione della fattura",false);
         add(taf.nuova_area_testo());
         
    }
    
}
