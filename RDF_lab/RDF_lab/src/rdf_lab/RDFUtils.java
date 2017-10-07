/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf_lab;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;

/**
 *
 * @author dstructx
 */
public class RDFUtils {

    public static Model readRDFFile(String filePath) {
        Model model = ModelFactory.createDefaultModel();

        InputStream ins = FileManager.get().open(filePath);
        if (ins == null) {
            throw new IllegalArgumentException("File: " + filePath + " not found");
        }

        model.read(new InputStreamReader(ins), "");
        return model;
    }

    public static void printRDFModel(Model model) {
        model.write(System.out);
        System.out.println();
    }

    public static void writeRDFModel(String baseDir, String fileName, Model model) {
        try {
            FileOutputStream fout = new FileOutputStream(baseDir + fileName + ".rdf");
            model.write(fout);
        }
        catch (IOException ioex) {
            System.out.println("Exception caught " + ioex.getMessage());
        }
    }

    public static void traversRDFModel(Model model) {
        StmtIterator iter = model.listStatements();

        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement();
            Resource subject = stmt.getSubject();
            Property predicate = stmt.getPredicate();
            RDFNode object = stmt.getObject();

            System.out.print(subject.toString());
            System.out.print(" " + predicate.toString() + " ");
            if (object instanceof Resource) {
                System.out.print(object.toString());
            }
            else {
                // object is a literal
                System.out.print(" \"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }
    }
}
