package createfepa.view.tab;

import createfepa.framework.Message;
import createfepa.framework.Tab;
import createfepa.view.TabCreationIf;
import cretefepa.model.TestataModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luca
 */
public final class Testata extends Tab implements TabCreationIf{


public TestataModel testata;
    public Testata(TestataModel testata, List<Message> list_message) {
         this.testata = testata;
         init();
         createComponentMap();
    }
@Override
    public void init(){
       JLabel jl = new javax.swing.JLabel();

        jl.setText("TipoDocumento");
         JLabel jl2 = new javax.swing.JLabel();

        jl2.setText("NumeroDocumento");
 JLabel jl3 = new javax.swing.JLabel();

        jl3.setText("Descrizione");
       
         JTextField jtf = new JTextField(10);
         jtf.setName("TipoDocumento");
         JTextField jtf2 = new JTextField(10);
         jtf2.setName("NumeroDocumento");
         JTextArea jta = new JTextArea();
         jta.setName("Descrizione");
         jta.setText("Scrivi qui la descrizione della fattura");
              JButton b = new JButton("Genera XML");
         b.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        // display/center the jdialog when the button is pressed
       verifica();
      }
    });
                          add(jl);

         add(jtf);
         add(jl2);
         add(jtf2);
         add(jl3);
         add(jta);
         add(b);

    }
public List<Message> lista_messaggi(){
   
    return this.lista_messaggi;
}
@Override
    public boolean verifica() {
            boolean validato=true;

        String[] messaggi;
        
        messaggi = new String[20];
        messaggi[0]="Errore! Il campo TipoDocumento è obbligatorio";
        messaggi[1]="Errore! Il campo TipoDocumento può essere TD01 o TD04";
        messaggi[2]="Errore! Il campo NumeroDocumento è obbligatorio";
JTextField jtf = (JTextField) getComponentByName("TipoDocumento");
JTextArea jta = (JTextArea) getComponentByName("Descrizione");
JTextField jtf2 = (JTextField) getComponentByName("NumeroDocumento");
this.lista_messaggi.clear();
 if("".equals(jtf.getText())){
     
             /* JOptionPane.showMessageDialog(this,
    messaggi[0]);
                        validato=false;*/
     Message msg = new Message("a",messaggi[0]);
     this.lista_messaggi.add(msg);
     validato=false;
     
         }
 else if("".equals(jtf2.getText())){
     
       Message msg = new Message("a",messaggi[2]);
     this.lista_messaggi.add(msg);
                 validato=false;
 }
 else if(! "TD01".equals(jtf.getText())&& !"TD04".equals(jtf.getText())){
         
           validato=false;
            Message msg = new Message("a",messaggi[1]);
     this.lista_messaggi.add(msg);
 }
         

return validato;
    }
    public TestataModel return_table_model(){
        if(verifica()){
        JTextField jtf = (JTextField) getComponentByName("TipoDocumento");
JTextArea jta = (JTextArea) getComponentByName("Descrizione");
JTextField jtf2 = (JTextField) getComponentByName("NumeroDocumento");
            TestataModel tm = new TestataModel(jtf2.getText(),jtf.getText(),jta.getText());
this.testata=tm;
    return tm;

        }
return null;
}
}
   
    
