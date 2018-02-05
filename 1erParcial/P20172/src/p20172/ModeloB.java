/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p20172;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.vocabulary.RDF;
import static p20172.RDFUtils.saveModel;
import static p20172.RDFUtils.url;

/**
 *
 * @author dstructx
 */
public class ModeloB {

    private static Resource animals[];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = initModel();
        model.add(createStatements(model));
        saveModel(model);
    }

    private static Model initModel() {
        Model model = ModelFactory.createDefaultModel();
        Resource reptil = model.createResource(url + "animal#reptile");
        Resource oso = model.createResource(url + "animal#bear");
        Resource animal_marino = model.createResource(url + "animal#sea_animal");

        int i = 0;
        animals = new Resource[13];

        animals[i] = model.createResource(url + "OsoPolar");
        animals[i].addProperty(RDF.type, oso);
        animals[i].addProperty(Animals.name, "oso polar");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "OsoPardo");
        animals[i].addProperty(RDF.type,oso);
        animals[i].addProperty(Animals.name, "oso pardo");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "OsoPanda");
        animals[i].addProperty(RDF.type, oso);
        animals[i].addProperty(Animals.name, "oso panda");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Lagarto");
        animals[i].addProperty(RDF.type, reptil);
        animals[i].addProperty(Animals.name, "lagarto");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Lagartija");
        animals[i].addProperty(RDF.type, reptil);
        animals[i].addProperty(Animals.name, "lagartija");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Serpiente");
        animals[i].addProperty(RDF.type, reptil);
        animals[i].addProperty(Animals.name, "serpiente");

        animals[++i] = model.createResource(url + "Iguana");
        animals[i].addProperty(RDF.type, reptil);
        animals[i].addProperty(Animals.name, "iguana");
        animals[i].addProperty(Animals.hasLegs, "true");

        Resource animal = model.createResource(Animals.getURI() + "animal");
        Resource zoo = model.createResource(Animals.getURI() + "zoologico");

        animals[++i] = model.createResource(url + "Cocodrilo");
        animals[i].addProperty(RDF.type, reptil);
        animals[i].addProperty(Animals.name, "cocodrilo");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.belongs, zoo);

        animals[++i] = model.createResource(url + "tigre");
        animals[i].addProperty(RDF.type, animal);
        animals[i].addProperty(Animals.name, "tigre");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.belongs, zoo);

        animals[++i] = model.createResource(url + "Mono");
        animals[i].addProperty(RDF.type, animal);
        animals[i].addProperty(Animals.name, "mono");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.belongs, zoo);

        animals[++i] = model.createResource(url + "Leon");
        animals[i].addProperty(RDF.type, animal);
        animals[i].addProperty(Animals.name, "leon");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.belongs, zoo);

        animals[++i] = model.createResource(url + "Jirafa");
        animals[i].addProperty(RDF.type, animal);
        animals[i].addProperty(Animals.name, "jirafa");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.belongs, zoo);

        animals[++i] = model.createResource(url + "Pinguino");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "pinguino");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        return model;
    }

    private static Statement[] createStatements(Model model) {
        return new Statement[] {
            // Osos
            model.createStatement(animals[0], Animals.family_sibling, animals[1]),
            model.createStatement(animals[0], Animals.family_sibling, animals[2]),

            model.createStatement(animals[1], Animals.family_sibling, animals[0]),
            model.createStatement(animals[1], Animals.family_sibling, animals[2]),

            model.createStatement(animals[2], Animals.family_sibling, animals[0]),
            model.createStatement(animals[2], Animals.family_sibling, animals[1]),

            // Reptiles
            model.createStatement(animals[3], Animals.family_sibling, animals[4]),
            model.createStatement(animals[3], Animals.family_sibling, animals[5]),
            model.createStatement(animals[3], Animals.family_sibling, animals[6]),
            model.createStatement(animals[3], Animals.family_sibling, animals[7]),

            model.createStatement(animals[4], Animals.family_sibling, animals[3]),
            model.createStatement(animals[4], Animals.family_sibling, animals[5]),
            model.createStatement(animals[4], Animals.family_sibling, animals[6]),
            model.createStatement(animals[4], Animals.family_sibling, animals[7]),

            model.createStatement(animals[5], Animals.family_sibling, animals[3]),
            model.createStatement(animals[5], Animals.family_sibling, animals[4]),
            model.createStatement(animals[5], Animals.family_sibling, animals[6]),
            model.createStatement(animals[5], Animals.family_sibling, animals[7]),

            model.createStatement(animals[6], Animals.family_sibling, animals[3]),
            model.createStatement(animals[6], Animals.family_sibling, animals[4]),
            model.createStatement(animals[6], Animals.family_sibling, animals[5]),
            model.createStatement(animals[6], Animals.family_sibling, animals[7]),

            model.createStatement(animals[7], Animals.family_sibling, animals[3]),
            model.createStatement(animals[7], Animals.family_sibling, animals[4]),
            model.createStatement(animals[7], Animals.family_sibling, animals[5]),
            model.createStatement(animals[7], Animals.family_sibling, animals[6]),

            // Zoologico
            model.createStatement(animals[8], Animals.shareHabitat, animals[9]),
            model.createStatement(animals[8], Animals.shareHabitat, animals[10]),
            model.createStatement(animals[8], Animals.shareHabitat, animals[11]),

            model.createStatement(animals[9], Animals.shareHabitat, animals[8]),
            model.createStatement(animals[9], Animals.shareHabitat, animals[10]),
            model.createStatement(animals[9], Animals.shareHabitat, animals[11]),

            model.createStatement(animals[10], Animals.shareHabitat, animals[8]),
            model.createStatement(animals[10], Animals.shareHabitat, animals[9]),
            model.createStatement(animals[10], Animals.shareHabitat, animals[11]),

            model.createStatement(animals[11], Animals.shareHabitat, animals[8]),
            model.createStatement(animals[11], Animals.shareHabitat, animals[9]),
            model.createStatement(animals[11], Animals.shareHabitat, animals[10]),

            // Oso polar
            model.createStatement(animals[0], Animals.shareHabitat, animals[12]),

            // Pinguino
            model.createStatement(animals[12], Animals.shareHabitat, animals[0]),
            model.createStatement(animals[12], Animals.eatenBy, animals[7]),

            // Cocodrilo 
            model.createStatement(animals[7], Animals.eat, animals[12]),

            model.createStatement(animals[7], Animals.shareHabitat, animals[8]),
            model.createStatement(animals[7], Animals.shareHabitat, animals[9]),
            model.createStatement(animals[7], Animals.shareHabitat, animals[10]),
            model.createStatement(animals[7], Animals.shareHabitat, animals[11]),

            model.createStatement(animals[8], Animals.shareHabitat, animals[7]),
            model.createStatement(animals[9], Animals.shareHabitat, animals[7]),
            model.createStatement(animals[10], Animals.shareHabitat, animals[7]),
            model.createStatement(animals[11], Animals.shareHabitat, animals[7])
        };
    }
}
