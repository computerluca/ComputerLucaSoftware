package createfepa.framework;

import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luca
 */
public abstract class Field {
    private String nome_campo;
    private String tipo_campo;
    private boolean obbligatorieta;

    public Field(String nome_campo, String tipo_campo, boolean obbligatorieta) {
        this.tipo_campo = tipo_campo;
        this.nome_campo=nome_campo;
        this.obbligatorieta = obbligatorieta;
    }

    public Field() {
    }

    public String getNome_campo() {
        return nome_campo;
    }

    public void setNome_campo(String nome_campo) {
        if(nome_campo.length()>100){
            Logger.getLogger("Errore nel nome campo. Campo maggiore di 100 caratteri");
        }
        else{
        this.nome_campo = nome_campo;
        }
    }

    public String getTipo_campo() {
        return tipo_campo;
    }

    public void setTipo_campo(String tipo_campo) {
        this.tipo_campo = tipo_campo;
    }

    public boolean isObbligatorieta() {
        return obbligatorieta;
    }

    public void setObbligatorieta(boolean obbligatorieta) {
        this.obbligatorieta = obbligatorieta;
    }
    public JTextField new_text_field(String tipo_campo,String obbligatorieta,String nome_campo){
        JTextField nuovo = new JTextField();
        return nuovo;
    }
    public JLabel new_label(String tipo_campo,String obbligatorieta,String nome_campo){
        JLabel nuovo = new JLabel();
        nuovo.setText(nome_campo);
        return nuovo;
    }
    
}
