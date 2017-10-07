/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rdf_lab;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.RDF;
import static rdf_lab.RDFUtils.printRDFModel;

/**
 *
 * @author dstructx
 */
public class Write_products {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        Resource personType = model.createResource("http://schema.org/Person#Person");
        Resource productType = model.createResource("http://schema.org/Product#Product");

        Resource r = model.createResource("http://example.com/Person/Sebas");
        r.addProperty(RDF.type, personType);
        r.addProperty(SchemaORG.name, "sebas");
        r.addProperty(SchemaORG.gender, SchemaORG.Male);

        Resource r2 = model.createResource("http://example.com/Person/Mike");
        r2.addProperty(RDF.type, personType);
        r2.addProperty(SchemaORG.name, "mike");
        r2.addProperty(SchemaORG.gender, SchemaORG.Male);

        Resource drum = model.createResource("http://example.com/Product");
        drum.addProperty(RDF.type, productType);
        drum.addProperty(SchemaORG.name, "snare");
        drum.addProperty(SchemaORG.material, "wood");

        r.addProperty(SchemaORG.knows, r2);
        r.addProperty(SchemaORG.owns, drum);
        r2.addProperty(SchemaORG.owns, drum);

        printRDFModel(model);
    }
}
