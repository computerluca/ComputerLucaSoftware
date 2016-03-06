/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.framework;

import java.awt.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author luca
 */
public class Tab extends JPanel {
   private String nome_tab;
public HashMap componentMap;
   public List<Message> lista_messaggi;

public final void createComponentMap() {
    
        componentMap = new HashMap<>();
        Component[] components = getComponents();
       for (Component component : components) {
           componentMap.put(component.getName(), component);
       }
}

public final Component getComponentByName(String name) {
        if (componentMap.containsKey(name)) {
                return (Component) componentMap.get(name);
        }
        else return null;
}
    public Tab() {
        createComponentMap();
                this.lista_messaggi = new ArrayList<>();

        
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

 
    

   

    
}
