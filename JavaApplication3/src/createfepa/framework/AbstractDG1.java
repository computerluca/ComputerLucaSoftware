
/*package createfepa.framework;



import createfepa.view.tab.Anagrafica;
import createfepa.view.tab.RigheDettaglio;
import createfepa.view.tab.Testata;
import createfepa.xml.XMLCreator;
import cretefepa.model.DGOperations;
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

public class AbstractDG1 extends JApplet implements DGOperations {
    
    
    public List<cretefepa.model.Tab> lista_tab;
    public JTabbedPane jtp; 
    public TestataModel tm;
    //Testata td = new Testata(this.tm);
    public List<RigaDettaglio> righe_dettaglio;
    RigheDettaglio rd;

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from
     * the event dispatch thread.
     
    
    
    public void crea_tab(){
        //jtp.add("Testata",new Testata());
        //add(jtp);
       // jtp.add("RigheDettaglio",new RigheDettaglio());
       // add(jtp);
        
    }
    public void crea_tabs(){
         this.rd= new RigheDettaglio(this.righe_dettaglio);
        this.jtp = new JTabbedPane();
        inizializza_lista_tab();
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
        }
        jtp.add("Risultati",r);
       JButton v = (JButton)r.getComponentByName("view");
       v.setEnabled(false);
               add(jtp);

       jtp.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
            if(jtp.getSelectedIndex()==3){
                if (td.return_table_model() == null && rd.return_model_righe().isEmpty()){
                } else {
                    if(!(rd.return_model_righe().isEmpty())){
                    tm = td.return_table_model();
                    righe_dettaglio = rd.return_model_righe();
                    String file_xml = null;
        
                    XMLCreator xc = null;
                    try {
                        xc = new XMLCreator(tm,file_xml,righe_dettaglio);
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(AbstractDG1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        file_xml=xc.crea_file_xml();
                    } catch (TransformerException ex) {
                        Logger.getLogger(AbstractDG1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JTextArea txtArea = new JTextArea(file_xml) {

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(900, 500);
    }

};
                   JFrame frame = new JFrame("Visualizzazione File XML");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane());
         JOptionPane.showMessageDialog(frame,
    txtArea);
                    
        //Add content to the window.
        
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                   
                    
                }     }   }}
    });
     
        
        
    }
    public void abilita_pulsante(){
           
    }
    public void colora_campi(){
        
    }
    
    public void createAndShowGUI() {
        
         
     
    }
    public void inizializza_lista_tab(){
        this.lista_tab = new ArrayList<>();
        cretefepa.model.Tab t = new cretefepa.model.Tab();
        t.setNome_tab("Testata");
       this.lista_tab.add(t);
       cretefepa.model.Tab t2 = new cretefepa.model.Tab();
        t2.setNome_tab("RigheDettaglio");
       this.lista_tab.add(t2);
              cretefepa.model.Tab t3 = new cretefepa.model.Tab();

    t3.setNome_tab("Anagrafica");
       this.lista_tab.add(t3);
    }
    @Override
    public void init() {
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Turn off metal's use of bold fonts
		                inizializza_lista_tab();    
crea_tabs();
            }

            
        });
    }

    @Override
    public void Salva() {
        
    }

    @Override
    public void Annulla() {

    
    }
}
*/
