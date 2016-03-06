/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cretefepa.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author luca
 */
public class RigheDettaglioTableModel extends AbstractTableModel {
    private List<RigaDettaglio> righe_dettaglio;
     
    private final String[] columnNames = new String[] {
            "NumeroLinea", "Descrizione", "Quantità", "Prezzo Unitario", "Prezzo Totale", "Aliquota IVA", "IVA","Prezzo Con iva"
    };
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, Double.class, Double.class, Double.class,Double.class,Double.class,Double.class
    };
 
    public RigheDettaglioTableModel(List<RigaDettaglio> righe_dettaglio)
    {
        this.righe_dettaglio = righe_dettaglio;
    }
     
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return righe_dettaglio.size();
    }

 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        RigaDettaglio row = righe_dettaglio.get(rowIndex);
        if(0 == columnIndex) {
            return row.numero_linea;
        }
        else if(1 == columnIndex) {
            return row.Descrizione;
        }
        else if(2 == columnIndex) {
            return row.quantita;
        }
        else if(3 == columnIndex) {
            return row.prezzo_unitario;
        }
         else if(4 == columnIndex) {
            return row.prezzo_totale;
        }
         else if(5== columnIndex){
             return row.aliquota_iva;
         }
        else if(6== columnIndex){
             return row.importo_iva;
         }
        else if(7== columnIndex){
             return row.totale_con_iva;
         }
        return null;
    }
    @Override
    public void setValueAt(Object avalue, int rowIndex, int columnIndex)
    {
        RigaDettaglio row = righe_dettaglio.get(rowIndex);
        if(0 == columnIndex) {
             row.numero_linea=(Integer) avalue;
        }
        else if(1 == columnIndex) {
            row.Descrizione=(String) avalue;
        }
        else if(2 == columnIndex) {
            row.quantita=Double.parseDouble(avalue.toString()) ;
        }
        else if(3 == columnIndex) {
            row.prezzo_unitario = (Double) avalue;
        }
         else if(4 == columnIndex) {
           row.prezzo_totale = (Double) avalue;
        }
         else if(5== columnIndex){
             row.aliquota_iva= (Double) avalue;
         }
        else if(6== columnIndex){
             row.importo_iva = (Double) avalue;
         }
        else if(7== columnIndex){
             row.totale_con_iva = (Double) avalue;
         }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
{
    return false;
}
}
