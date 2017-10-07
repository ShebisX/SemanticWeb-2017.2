/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf_lab;

import java.io.File;
import javax.swing.JFileChooser;
import org.apache.jena.rdf.model.Model;
import static rdf_lab.RDFUtils.*;

/**
 *
 * @author dstructx
 */
public class VCard_union {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();

        Model modelA;
        Model modelB;
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = jfc.getSelectedFile();
            String baseDir = file.getParent() + "/";
            String namePrefix = "myContactCard";

            modelA = readRDFFile(file.getAbsolutePath());
            printRDFModel(modelA);

            if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                modelB = readRDFFile(jfc.getSelectedFile().getAbsolutePath());
                printRDFModel(modelB);

                Model unionModel = modelA.union(modelB);
                Model intersectionModelA = modelA.intersection(unionModel);
                Model intersectionModelB = modelB.intersection(unionModel);

                printRDFModel(unionModel);
                printRDFModel(intersectionModelA);
                printRDFModel(intersectionModelB);

                writeRDFModel(baseDir, namePrefix + "Union", unionModel);
                writeRDFModel(baseDir, namePrefix + "Intersection1", intersectionModelA);
                writeRDFModel(baseDir, namePrefix + "Intersection2", intersectionModelB);
            }
        }
    }
}
