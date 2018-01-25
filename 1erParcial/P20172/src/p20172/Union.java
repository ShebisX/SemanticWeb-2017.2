/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20172;

import java.io.File;
import javax.swing.JFileChooser;
import org.apache.jena.rdf.model.Model;
import static p20172.RDFUtils.readRDFFile;
import static p20172.RDFUtils.saveModel;

/**
 *
 * @author dstructx
 */
public class Union {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        jfc.setMultiSelectionEnabled(true);

        Model model;
        Model auxiliar;

        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            int i = 0;
            File files[] = jfc.getSelectedFiles();

            File file = files[i++];
            model = readRDFFile(file.getAbsolutePath());

            for (; i < files.length; i++) {
                auxiliar = readRDFFile(files[i].getAbsolutePath());
                model = model.union(auxiliar);
            }

            saveModel(model);
        }
    }
    
}
