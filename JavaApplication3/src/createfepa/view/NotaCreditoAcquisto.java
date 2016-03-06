/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

package createfepa.view;

import cretefepa.model.Tab;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author luca
 
public class NotaCreditoAcquisto extends FatturaAcquisto {
    @Override
    public void crea_tabs(){
        this.lista_tab = new ArrayList<>();

        Tab t = new Tab();
        t.setNome_tab("Anagrafica");
        this.lista_tab.add(t);
        super.crea_tabs();
        
    }
    @Override
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
    }
}*/
