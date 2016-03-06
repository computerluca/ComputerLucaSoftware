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
public class RigaDettaglio {
    public Integer numero_linea;
    public String Descrizione;
    public double quantita;
    public double prezzo_unitario;
    public double prezzo_totale;
    public double aliquota_iva;
    public double importo_iva;
    public double totale_con_iva;
    public RigaDettaglio(Integer numero_linea, String Descrizione, double quantita, double prezzo_unitario, double prezzo_totale, double aliquota_iva, double importo_iva, double totale_con_iva) {
        this.numero_linea = numero_linea;
        this.Descrizione = Descrizione;
        this.quantita = quantita;
        this.prezzo_unitario = prezzo_unitario;
        this.prezzo_totale = prezzo_totale;
        this.aliquota_iva = aliquota_iva;
        this.importo_iva = importo_iva;
        this.totale_con_iva = totale_con_iva;
    }
    
}
