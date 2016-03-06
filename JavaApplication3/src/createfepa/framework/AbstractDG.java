
package createfepa.framework;



import createfepa.view.Home;
import createfepa.view.tab.Anagrafica;
import createfepa.view.tab.AnagraficaC;
import createfepa.view.tab.Pagamento;
import createfepa.view.tab.RigheDettaglio;
import createfepa.view.tab.Testata;
import createfepa.xml.XMLCreator;
import cretefepa.model.RigaDettaglio;
import cretefepa.model.TestataModel;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

public class AbstractDG extends JPanel {
    
    
    public List<cretefepa.model.Tab> lista_tab;
    public JTabbedPane jtp; 
    public List<Message> lista_messaggi;
                public TestataModel tm = null;
final Testata td = new Testata(tm,this.lista_messaggi);
    List<RigaDettaglio> righe_dettaglio = null;
    RigheDettaglio rd;

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     
     */
    
    public void crea_tab(){
        //jtp.add("Testata",new Testata());
        //add(jtp);
       // jtp.add("RigheDettaglio",new RigheDettaglio());
       // add(jtp);
        
    }
public void crea_lista_messaggi(){
       td.verifica();
       rd.verifica();
       this.lista_messaggi.clear();
       this.lista_messaggi.addAll(td.lista_messaggi);
              this.lista_messaggi.addAll(rd.lista_messaggi);

}

    /**
     *
     * @param lista_tab
     */
    public void crea_tabs(List <cretefepa.model.Tab> lista_tab){
this.lista_tab = lista_tab;
        
         this.lista_messaggi = new ArrayList<>();
         rd= new RigheDettaglio(righe_dettaglio);
        this.jtp = new JTabbedPane();
       Risultati r = new Risultati();
        for(cretefepa.model.Tab t: this.lista_tab){
            if(t.getNome_tab().equals("RigheDettaglio")){
                jtp.add("RigheDettaglio",rd);
            }
            if(t.getNome_tab().equals("Testata")){
                jtp.add("Testata",td);
            }
            if(t.getNome_tab().equals("Anagrafica")){
                jtp.add("Anagrafica",new Anagrafica());
            }
            if(t.getNome_tab().equals("AnagraficaC")){
                jtp.add("AnagraficaCliente",new AnagraficaC());
            }
             if(t.getNome_tab().equals("Pagamento")){
                jtp.add("Dati relativi al pagamento",new Pagamento());
            }
        }
        jtp.add("Risultati",r);
       JButton v = (JButton)r.getComponentByName("view");
       v.setEnabled(false);
               add(jtp);
       jtp.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
           
            if(jtp.getSelectedIndex()==2){
                crea_lista_messaggi();

                Salva();
                
               
                    
    
            }
        }
               });
    }
  
    /* public void init() {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Turn off metal's use of bold fonts

            }

            
        });
  
    }*/
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AbstractDG().setVisible(true);
            }
        });
    }
    
    public boolean valida_documento(){
        
       return this.lista_messaggi.isEmpty(); 
    }
    public void genera_messaggi_errore(){
        for(Message m: this.lista_messaggi){
            JOptionPane.showMessageDialog(this,m.message);
            System.out.println(m.message);
        }
        
    }
    public void Salva() {
        if(valida_documento()){
            crea_file_xml();
        }
        else{
            genera_messaggi_errore();
        }
    }

    public void Annulla() {

    
    }

    private void crea_file_xml() {
tm = td.return_table_model();
                    righe_dettaglio = rd.return_model_righe();
                    String file_xml = null;
        
                    XMLCreator xc = null;
                    try {
                        xc = new XMLCreator(tm,file_xml,righe_dettaglio);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(AbstractDG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        file_xml=xc.crea_file_xml();
                    } catch (TransformerException ex) {
                        Logger.getLogger(AbstractDG.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JTextArea txtArea = new JTextArea(file_xml) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(900, 500);
    }

};
                   JFrame frame = new JFrame("Visualizzazione File XML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jsp = new JScrollPane(txtArea);
         JOptionPane.showMessageDialog(frame,
    jsp);
                    
        //Add content to the window.
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                   
                    
    }
        
}
