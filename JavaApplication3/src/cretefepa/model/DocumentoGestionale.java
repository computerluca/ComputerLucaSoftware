/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cretefepa.model;

import createfepa.framework.Tab;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luca
 */
public abstract class DocumentoGestionale implements DGOperations  {
    public String tipo_documento;
    public Integer numero_documento;
    public DocumentoGestionale(){
        this.tipo_documento = "ABSTRACT_DG";
        this.numero_documento = -1;
        
    } 

    @Override
    public void Salva() {

    }

    @Override
    public void Annulla() {

    }
}
