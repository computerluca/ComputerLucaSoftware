/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cretefepa.model;

/**
 *
 * @author luca
 */
public class TestataModel {
    public String numero_documento;
    public String tipo_documento;
    public String descrizione;
    public TestataModel(String numero_documento, String tipo_documento,String descrizione) {
        this.numero_documento = numero_documento;
        this.tipo_documento = tipo_documento;
        this.descrizione = descrizione;
    }
    
}
