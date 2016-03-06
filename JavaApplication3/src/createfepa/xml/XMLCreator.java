/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package createfepa.xml;

import cretefepa.model.RigaDettaglio;
import cretefepa.model.TestataModel;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 *
 * @author luca
 */
public class XMLCreator {
public  DocumentBuilderFactory docFactory;
public	DocumentBuilder docBuilder;
public  Document doc;
public String file_xml;
public TestataModel tm;
public List<RigaDettaglio> righe_dettaglio;
    public XMLCreator(TestataModel tm,String file_xml,List<RigaDettaglio> righe_dettaglio) throws ParserConfigurationException {
         this.docFactory= DocumentBuilderFactory.newInstance();
	this.docBuilder= docFactory.newDocumentBuilder();
        		this.doc= this.docBuilder.newDocument();
                     this.tm=tm; 
                     this.file_xml = file_xml;
                     this.righe_dettaglio =righe_dettaglio;

    }
    public String crea_file_xml() throws TransformerException{
      apri_file();
      crea_testata();
      crea_righe_dettaglio();
      chiudi_file();
      return this.file_xml;
    }
    public void apri_file() throws TransformerConfigurationException, TransformerException{
       

		

		// root elements
		Element rootElement = this.doc.createElement("p:FatturaElettronica");
                rootElement.setAttribute("xmlns:ds","http://www.w3.org/2000/09/xmldsig#");
                rootElement.setAttribute("xmlns:p","http://www.fatturapa.gov.it/sdi/fatturapa/v1.1");
                rootElement.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
                              rootElement.setAttribute("versione", "1.1");

                this.doc.appendChild(rootElement);
                Element header = this.doc.createElement("FatturaElettronicaHeader");
                rootElement.appendChild(header);
                Element trasm = this.doc.createElement("DatiTrasmissione");
                header.appendChild(trasm);
                Element trasm2 = this.doc.createElement("IdTrasmittente");
                trasm.appendChild(trasm2);
                Element trasm3 = this.doc.createElement("IdPaese");
                trasm3.setTextContent("IT");
                trasm2.appendChild(trasm3);
                 Element trasm4 = this.doc.createElement("IdCodice");
                 trasm4.setTextContent("CODFISCALE070628");
                trasm2.appendChild(trasm4);
                Element trasm5 = this.doc.createElement("ProgressivoInvio");
                trasm5.setTextContent("00001");
                trasm.appendChild(trasm5);
                Element trasm6 = this.doc.createElement("FormatoTrasmissione");
                trasm6.setTextContent("SDI11");
                trasm.appendChild(trasm6);
                Element trasm7 = this.doc.createElement("CodiceDestinatario");
                trasm7.setTextContent("000000");
                trasm.appendChild(trasm7);
               
               
               
                
		// staff elements
		Element staff =this.doc.createElement("FatturaElettronicaBody");
		rootElement.appendChild(staff);
                Element staff2 = this.doc.createElement("DatiGenerali");
                staff.appendChild(staff2);
		

		


		// write the content into xml file
		


		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);

		
   

    }
    
    private void crea_testata(){
        		Element staff2 = this.doc.createElement("DatiGeneraliDocumento");
                Node staff = (Element) this.doc.getElementsByTagName("DatiGenerali").item(0);
    staff.appendChild(staff2);
    Element staff3 = this.doc.createElement("TipoDocumento");
    staff3.setTextContent(this.tm.tipo_documento);
    Element staff4 = this.doc.createElement("NumeroDocumento");
    staff4.setTextContent(this.tm.numero_documento);
        Element staff5 = this.doc.createElement("Causale");
        staff5.setTextContent(this.tm.descrizione);
        staff2.appendChild(staff3);
                staff2.appendChild(staff4);
        staff2.appendChild(staff5);


    }
    public void chiudi_file() throws TransformerConfigurationException, TransformerException{
     // write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(doc);
		StreamResult result = new StreamResult(this.file_xml);

		// Output to console for testing
		// StreamResult result = new StreamResult(System.out);
 transformer.setParameter(OutputKeys.INDENT, "yes");
 transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
     transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      ByteArrayOutputStream s = new ByteArrayOutputStream();
      
	transformer.transform(source, new StreamResult(s));
                this.file_xml=s.toString();
    }

    private void crea_righe_dettaglio() {
                Node staff = (Element) this.doc.getElementsByTagName("FatturaElettronicaBody").item(0);
                Element staff2 = this.doc.createElement("DatiBeniServizi");
                staff.appendChild(staff2);
                for(RigaDettaglio riga: righe_dettaglio){
                Element staff3 = this.doc.createElement("DettaglioLinee");
                                staff2.appendChild(staff3);

                Element nl = this.doc.createElement("NumeroLinea");
                nl.setTextContent(riga.numero_linea.toString());
                Element nl2 = this.doc.createElement("Descrizione");
                nl2.setTextContent(riga.Descrizione);
                 Element nl3 = this.doc.createElement("Quantita");
                 String ciao = String.valueOf(riga.quantita);
                 nl3.setTextContent(ciao);
                 
             
                 Element nl4 = this.doc.createElement("PrezzoUnitario");
                nl4.setTextContent(String.valueOf(riga.prezzo_unitario));
                Element nl5 = this.doc.createElement("PrezzoTotale");
                nl5.setTextContent(String.valueOf(riga.prezzo_totale));
                 Element nl6 = this.doc.createElement("AliquotaIVA");
                nl6.setTextContent(String.valueOf(riga.aliquota_iva));
                staff3.appendChild(nl);
                                staff3.appendChild(nl2);

                                                staff3.appendChild(nl3);

                                                               staff3.appendChild(nl4);
                staff3.appendChild(nl5);

                staff3.appendChild(nl6);

                                                                
                }
    }
    

}