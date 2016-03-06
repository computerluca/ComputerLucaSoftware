/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.view;

/**
 *
 * @author luca
 */


import createfepa.framework.AbstractDG;
import cretefepa.model.Tab;
import java.util.ArrayList;
import javax.swing.*;

public class FatturaAcquisto extends AbstractDG {
    
    
  FatturaAcquisto(){
      crea_tabs();
  }


    
   
    
    public void crea_tabs(){
                this.lista_tab = new ArrayList<>();

        Tab t = new Tab();
        t.setNome_tab("RigheDettaglio");
        Tab t2 = new Tab();
        t2.setNome_tab("Testata");
         Tab t3 = new Tab();
        t3.setNome_tab("Anagrafica");
      this.lista_tab.add(t3);

                this.lista_tab.add(t2);

        this.lista_tab.add(t);
        inizializza_lista_tab();
       super.crea_tabs(this.lista_tab);
        
       
    }
    public void inizializza_lista_tab(){
       
    }
   
    
   
     public static void main(String args[]) {
       
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame();
                jf.add(new FatturaAcquisto());
                jf.setVisible(true);
            }
        });
    }
    /*@Override
    public void init() {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Turn off metal's use of bold fonts
                crea_tabs();
            }

            
        });
    }*/

   
}

