/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.view.tab;

import createfepa.framework.Message;
import createfepa.framework.Tab;
import createfepa.view.TabCreationIf;
import cretefepa.model.RigaDettaglio;
import cretefepa.model.RigheDettaglioTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author luca
 */
public final class RigheDettaglio extends Tab implements TabCreationIf{
    public  JTable table;
                      public RigheDettaglioTableModel model;
        List<RigaDettaglio> righe_dettaglio;

    public RigheDettaglio(List<RigaDettaglio> righe_dettaglio) {
        this.righe_dettaglio = righe_dettaglio;
        init();
        createComponentMap();

}

    @Override
    public boolean verifica() {
          boolean validato=true;

        String[] messaggi;
        
        messaggi = new String[20];
        messaggi[0]="Errore! La fattura non presenta righe dettaglio";

 
 
 if(this.righe_dettaglio.isEmpty()){
           this.lista_messaggi.add(new Message("e",messaggi[0]));
          
           validato=false;
 }
         

return validato;
    }
    @Override
    public void init(){
        this.righe_dettaglio = new ArrayList<>();
        this.model= new RigheDettaglioTableModel(righe_dettaglio);
            JLabel descrizionel = new JLabel("Descrizione riga");
            
         JTextArea descrizione = new JTextArea();
         descrizione.setText("inserisci qui la descrizione");
         descrizione.setName("d");
          JLabel quantital = new JLabel("Quantità");
          
            
         JTextField quantita = new JTextField(10);
         quantita.setName("q");
         
           JLabel prezzo_unitariol = new JLabel("PrezzoUnitario");
            
         JTextField prezzo_unitario = new JTextField(10);
         prezzo_unitario.setName("pu");
         JLabel prezzo_totalel = new JLabel("PrezzoTotale");
            
         JTextField prezzo_totale = new JTextField(10);
         prezzo_totale.setEnabled(false);
         prezzo_totale.setName("pt");
         JLabel aliquota_ival = new JLabel("AliquotaIVA");
         JTextField aliquota_iva = new JTextField(10);
         aliquota_iva.setName("ai");
          JLabel ival = new JLabel("ImportoIVA");
          

         JTextField iva = new JTextField(10);
         iva.setName("ii");
         iva.setEnabled(false);
                   JLabel totival = new JLabel("Totale con IVA");

              JTextField totiva = new JTextField(10);
              
                       totiva.setEnabled(false);
                       totiva.setName("ti");

         add(descrizionel);

                          add(descrizione);
                          add(quantital);

add(quantita);
add(prezzo_unitariol);
add(prezzo_unitario);
add(prezzo_totalel);
add(prezzo_totale);
add(aliquota_ival);
add(aliquota_iva);
add(ival); add(iva); add(totival); add(totiva);


         
        
       

         this.table = new JTable(model);
        //add the table to the frame
        this.add(new JScrollPane(this.table));
       
        
        JButton c = new JButton("Nuovariga");
        c.setName("n");
        this.add(c);
        
        c.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                azzera_campi();
                                        disabilitapulsantenuovo();

                JButton d = new JButton("Salva Riga");
                d.setName("s");
                add(d);
                updateUI();
                        createComponentMap();

                d.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        riattivapulsantenuovo();
                        RigaDettaglio rd = calcola_valori2(); //To change body of generated methods, choose Tools | Templates.
                        nuova_riga(rd);
                        disabilitapulsantesalva();
                        azzera_campi();
                    }
                    
                });
            }
            
        });
                
this.table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
        @Override
        public void valueChanged(ListSelectionEvent event) {
            // do some actions here, for example
            // print first column value from selected row
            if(event.getValueIsAdjusting() ){
                disabilitapulsantenuovo();
                if(verifica_campo("a")&& verifica_campo("de")){
                
                    JButton giustizia = new JButton();
                    giustizia.setName("a");
                    giustizia.setText("Aggiorna Riga");
                    giustizia.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            riattivapulsantenuovo();
                            disabilitapulsante("a");
                            disabilitapulsante("de");
                        }
                    });
                    
                    
                    add(giustizia);
                    JButton giustizia2 = new JButton();
                    giustizia2.setName("de");
                    giustizia2.setText("Cancella riga");
                     giustizia2.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            riattivapulsantenuovo();
                            disabilitapulsante("a");
                            disabilitapulsante("de");
                        }
                    });
                    
                    add(giustizia2);
                    valorizza_campi_riga(table.getSelectedRow());
                    createComponentMap();
                    updateUI();
                } 
                else{
                    
                                    disabilitapulsantenuovo();

                    valorizza_campi_riga(table.getSelectedRow());
                    createComponentMap();
                    updateUI();
                
                }
            
        }
        }
    });
           

          
    }
    public boolean verifica_campo(String t){
        return this.getComponentByName(t)==null;
    }
    public void valorizza_campi_riga(int numero_riga){
         JTextField q = (JTextField)this.getComponentByName("q");
            JTextField pu = (JTextField)this.getComponentByName("pu");
            JTextField pt = (JTextField)this.getComponentByName("pt");
            JTextField ii = (JTextField)this.getComponentByName("ii");
                        JTextField ai = (JTextField)this.getComponentByName("ai");
            JTextField ti = (JTextField)this.getComponentByName("ti");
            JTextArea d = (JTextArea) this.getComponentByName("d");
           d.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
           q.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
           pu.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
            pt.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
           ai.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
           ii.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
           ti.setText(table.getValueAt(table.getSelectedRow(), 7).toString());



                                    System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
                                    

    }
    public void nuova_riga(RigaDettaglio r){
        this.righe_dettaglio.add(r);
        RigheDettaglioTableModel rd = new RigheDettaglioTableModel(this.righe_dettaglio);
        this.table.setModel(rd);
        this.model.fireTableDataChanged();
        updateUI();
    }
    public void calcola_valori(){
      JTextField q = (JTextField)this.getComponentByName("q");
            JTextField pu = (JTextField)this.getComponentByName("pu");
            JTextField pt = (JTextField)this.getComponentByName("pt");
            JTextField ii = (JTextField)this.getComponentByName("ii");
                        JTextField ai = (JTextField)this.getComponentByName("ai");
            JTextField ti = (JTextField)this.getComponentByName("ti");


    Double totale = Double.parseDouble(q.getText())*Double.parseDouble(pu.getText());
    pt.setText(totale.toString());
    Double iva = (totale*Double.parseDouble(ai.getText()))/100; 
    ii.setText(iva.toString());
    Double totale_con_iva = totale+iva;
    ti.setText(totale_con_iva.toString());
}
    public RigaDettaglio calcola_valori2(){
      JTextField q = (JTextField)this.getComponentByName("q");
            JTextArea d = (JTextArea)this.getComponentByName("d");

            JTextField pu = (JTextField)this.getComponentByName("pu");
            JTextField pt = (JTextField)this.getComponentByName("pt");
            JTextField ii = (JTextField)this.getComponentByName("ii");
                        JTextField ai = (JTextField)this.getComponentByName("ai");
            JTextField ti = (JTextField)this.getComponentByName("ti");

    Double totale = Double.parseDouble(q.getText())*Double.parseDouble(pu.getText());
    pt.setText(totale.toString());
    Double iva = (totale*Double.parseDouble(ai.getText()))/100; 
    ii.setText(iva.toString());
    Double totale_con_iva = totale+iva;
    ti.setText(totale_con_iva.toString());
                RigaDettaglio nr = new RigaDettaglio(this.table.getRowCount()+1,d.getText(),Double.parseDouble(q.getText()),Double.parseDouble(pu.getText()),Double.parseDouble(pt.getText()),Double.parseDouble(ai.getText()),Double.parseDouble(ii.getText()),Double.parseDouble(ti.getText()));
                return nr;

}
    public void azzera_campi(){
         JTextField q = (JTextField)this.getComponentByName("q");
            JTextField pu = (JTextField)this.getComponentByName("pu");
            JTextField pt = (JTextField)this.getComponentByName("pt");
            JTextField ii = (JTextField)this.getComponentByName("ii");
                        JTextField ai = (JTextField)this.getComponentByName("ai");
            JTextField ti = (JTextField)this.getComponentByName("ti");
            q.setText("");
            pu.setText("");
            pt.setText("");
            ii.setText("");
           ai.setText("");
           ti.setText("");
    }
    public void disabilitapulsantenuovo(){
         JButton q = (JButton)this.getComponentByName("n");
          q.setVisible(false);
    }
    public void abilitapulsantesalva(){
         JButton q = (JButton)this.getComponentByName("s");
          q.setVisible(true);
    }
    
    public void disabilitapulsantesalva(){
         JButton q = (JButton)this.getComponentByName("s");
          q.setVisible(false);
    }
    public void disabilitapulsante(String t){
        JButton q =(JButton)this.getComponentByName(t);
        q.setVisible(false);
        this.remove(q);
    }
    public void riattivapulsantenuovo(){
         JButton q = (JButton)this.getComponentByName("n");
          q.setVisible(true);
    }
    public List<RigaDettaglio> return_model_righe(){
        verifica();
        return this.righe_dettaglio;
    }
       
/*final JTextField currentCell = new JTextField();
 
    TableColumnModel tcm = table.getColumnModel();
    tcm.getColumn(2).setCellEditor(new DefaultCellEditor(currentCell));
    currentCell.addKeyListener(new KeyAdapter() {
       @Override
       public void keyTyped(KeyEvent e) {
           Double Quantita=0.0;
           Quantita = Double.parseDouble(currentCell.getText());
              Double prezzo_unitario;
           prezzo_unitario = Double.parseDouble(table.getValueAt(table.getSelectedRow(),2).toString());
              Double prezzo_totale = prezzo_unitario * Quantita;
              System.out.println(prezzo_totale);
              table.setValueAt(prezzo_totale,table.getSelectedRow(),4);
       }
  }   );*/
    }


    


    