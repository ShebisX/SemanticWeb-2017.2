package rdf_lab;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.jena.rdf.model.*;
import static rdf_lab.RDFUtils.*;

/**
 *
 * @author dstructx
 */
public class RDF_lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFileChooser jfc = new JFileChooser();
        jfc.setMultiSelectionEnabled(true);

        Model model;
        Model auxiliar;

        JOptionPane.showMessageDialog(null, "Select your files");
        if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            int i = 0;
            File files[] = jfc.getSelectedFiles();

            File file = files[i++];
            model = readRDFFile(file.getAbsolutePath());

            for (; i < files.length; i++) {
                auxiliar = readRDFFile(files[i].getAbsolutePath());
                model = model.union(auxiliar);
            }
            printRDFModel(model);

            JOptionPane.showMessageDialog(null, "Select file to save model");
            jfc.setMultiSelectionEnabled(false);
            if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                File saveFile = jfc.getSelectedFile();
                String baseDir = saveFile.getParent() + "/";
                String fileName = saveFile.getName();
                writeRDFModel(baseDir, fileName, model);
            }
        }
    }
}
