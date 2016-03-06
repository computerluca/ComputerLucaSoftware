/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cretefepa.model;

import createfepa.framework.Field;
import java.util.List;

/**
 *
 * @author luca
 */
public class Tab {
    private String nome_tab;
   private List<Field> lista_campi;

   Tab(String nt,List<Field> lista_campi){
       this.nome_tab =nt;
   }

    public Tab() {
        
    }
   /*public JPanel Nuovo_Tab(){
             
        JLabel filler = new JLabel("ciao");
        add(filler);
   }*/

    public String getNome_tab() {
        return nome_tab;
    }

    public void setNome_tab(String nome_tab) {
        this.nome_tab = nome_tab;
    }

    public List<Field> getLista_campi() {
        return lista_campi;
    }

    public void setLista_campi(List<Field> lista_campi) {
        this.lista_campi = lista_campi;
    }
}
