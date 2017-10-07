/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf_lab;

import javax.swing.JFileChooser;
import static rdf_lab.RDFUtils.readRDFFile;
import static rdf_lab.RDFUtils.traversRDFModel;

/**
 *
 * @author dstructx
 */
public class Travers_model {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            traversRDFModel(readRDFFile(jfc.getSelectedFile().getPath()));
        }
    }
}
