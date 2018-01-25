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
public class ModeloA {

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
        Resource animal_domestico = model.createResource(url + "animal#domestic_animal");
        Resource ave = model.createResource(url + "animal#bird");
        Resource animal_marino = model.createResource(url + "animal#sea_animal");

        int i = 0;
        animals = new Resource[14];

        animals[i] = model.createResource(url + "Perro");
        animals[i].addProperty(RDF.type, animal_domestico);
        animals[i].addProperty(Animals.name, "perro");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Gato");
        animals[i].addProperty(RDF.type, animal_domestico);
        animals[i].addProperty(Animals.name, "gato");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Hamster");
        animals[i].addProperty(RDF.type, animal_domestico);
        animals[i].addProperty(Animals.name, "hamster");
        animals[i].addProperty(Animals.hasLegs, "true");

        animals[++i] = model.createResource(url + "Canario");
        animals[i].addProperty(RDF.type, animal_domestico);
        animals[i].addProperty(Animals.name, "canario");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        animals[++i] = model.createResource(url + "Papagayo");
        animals[i].addProperty(RDF.type, ave);
        animals[i].addProperty(Animals.name, "papagayo");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        animals[++i] = model.createResource(url + "Buitre");
        animals[i].addProperty(RDF.type, ave);
        animals[i].addProperty(Animals.name, "buitre");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        animals[++i] = model.createResource(url + "Aguila");
        animals[i].addProperty(RDF.type, ave);
        animals[i].addProperty(Animals.name, "aguila");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        animals[++i] = model.createResource(url + "Pajaro");
        animals[i].addProperty(RDF.type, ave);
        animals[i].addProperty(Animals.name, "pajaro");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        animals[++i] = model.createResource(url + "Besugo");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "besugo");
        animals[i].addProperty(Animals.hasLegs, "false");
        animals[i].addProperty(Animals.hasWings, "false");

        animals[++i] = model.createResource(url + "Tiburon");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "tiburon");
        animals[i].addProperty(Animals.hasLegs, "false");
        animals[i].addProperty(Animals.hasWings, "false");

        animals[++i] = model.createResource(url + "Delfin");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "delfin");
        animals[i].addProperty(Animals.hasLegs, "false");
        animals[i].addProperty(Animals.hasWings, "false");

        animals[++i] = model.createResource(url + "Ballena");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "ballena");
        animals[i].addProperty(Animals.hasLegs, "false");
        animals[i].addProperty(Animals.hasWings, "false");

        animals[++i] = model.createResource(url + "Pez");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "pez");
        animals[i].addProperty(Animals.hasLegs, "false");
        animals[i].addProperty(Animals.hasWings, "false");

        animals[++i] = model.createResource(url + "Pinguino");
        animals[i].addProperty(RDF.type, animal_marino);
        animals[i].addProperty(Animals.name, "pinguino");
        animals[i].addProperty(Animals.hasLegs, "true");
        animals[i].addProperty(Animals.hasWings, "true");

        return model;
    }

    private static Statement[] createStatements(Model model) {
        return new Statement[] {
            // Animales domesticos
            model.createStatement(animals[0], Animals.shareHabitat, animals[1]),
            model.createStatement(animals[0], Animals.shareHabitat, animals[2]),
            model.createStatement(animals[0], Animals.shareHabitat, animals[3]),

            model.createStatement(animals[1], Animals.shareHabitat, animals[0]),
            model.createStatement(animals[1], Animals.shareHabitat, animals[2]),
            model.createStatement(animals[1], Animals.shareHabitat, animals[3]),

            model.createStatement(animals[2], Animals.shareHabitat, animals[0]),
            model.createStatement(animals[2], Animals.shareHabitat, animals[1]),
            model.createStatement(animals[2], Animals.shareHabitat, animals[3]),

            model.createStatement(animals[3], Animals.shareHabitat, animals[0]),
            model.createStatement(animals[3], Animals.shareHabitat, animals[1]),
            model.createStatement(animals[3], Animals.shareHabitat, animals[2]),
            model.createStatement(animals[3], Animals.family_sibling, animals[7]),

            // Aves
            model.createStatement(animals[4], Animals.family_sibling, animals[5]),
            model.createStatement(animals[4], Animals.family_sibling, animals[6]),
            model.createStatement(animals[4], Animals.family_sibling, animals[7]),

            model.createStatement(animals[5], Animals.family_sibling, animals[4]),
            model.createStatement(animals[5], Animals.family_sibling, animals[6]),
            model.createStatement(animals[5], Animals.family_sibling, animals[7]),

            model.createStatement(animals[6], Animals.family_sibling, animals[4]),
            model.createStatement(animals[6], Animals.family_sibling, animals[5]),
            model.createStatement(animals[6], Animals.family_sibling, animals[7]),

            model.createStatement(animals[7], Animals.family_sibling, animals[3]),
            model.createStatement(animals[7], Animals.family_sibling, animals[4]),
            model.createStatement(animals[7], Animals.family_sibling, animals[5]),
            model.createStatement(animals[7], Animals.family_sibling, animals[6]),

            // Animales marinos
            model.createStatement(animals[8], Animals.family_sibling, animals[9]),
            model.createStatement(animals[8], Animals.family_sibling, animals[10]),
            model.createStatement(animals[8], Animals.family_sibling, animals[11]),
            model.createStatement(animals[8], Animals.family_sibling, animals[12]),
            model.createStatement(animals[8], Animals.family_sibling, animals[13]),

            model.createStatement(animals[9], Animals.family_sibling, animals[8]),
            model.createStatement(animals[9], Animals.family_sibling, animals[10]),
            model.createStatement(animals[9], Animals.family_sibling, animals[11]),
            model.createStatement(animals[9], Animals.family_sibling, animals[12]),
            model.createStatement(animals[9], Animals.family_sibling, animals[13]),

            model.createStatement(animals[10], Animals.family_sibling, animals[8]),
            model.createStatement(animals[10], Animals.family_sibling, animals[9]),
            model.createStatement(animals[10], Animals.family_sibling, animals[11]),
            model.createStatement(animals[10], Animals.family_sibling, animals[12]),
            model.createStatement(animals[10], Animals.family_sibling, animals[13]),

            model.createStatement(animals[11], Animals.family_sibling, animals[8]),
            model.createStatement(animals[11], Animals.family_sibling, animals[9]),
            model.createStatement(animals[11], Animals.family_sibling, animals[10]),
            model.createStatement(animals[11], Animals.family_sibling, animals[12]),
            model.createStatement(animals[11], Animals.family_sibling, animals[13]),

            model.createStatement(animals[12], Animals.family_sibling, animals[8]),
            model.createStatement(animals[12], Animals.family_sibling, animals[9]),
            model.createStatement(animals[12], Animals.family_sibling, animals[10]),
            model.createStatement(animals[12], Animals.family_sibling, animals[11]),
            model.createStatement(animals[12], Animals.family_sibling, animals[13]),

            // Pinguino
            model.createStatement(animals[13], Animals.shareHabitat, animals[8]),
            model.createStatement(animals[13], Animals.shareHabitat, animals[9]),
            model.createStatement(animals[13], Animals.shareHabitat, animals[10]),
            model.createStatement(animals[13], Animals.shareHabitat, animals[11]),
            model.createStatement(animals[13], Animals.shareHabitat, animals[12]),

            model.createStatement(animals[13], Animals.eat, animals[12]),
            model.createStatement(animals[12], Animals.eatenBy, animals[13]),

            model.createStatement(animals[13], Animals.family_sibling, animals[7]),
            model.createStatement(animals[7], Animals.family_sibling, animals[13]),

            // Relacion pajaro-pez
            model.createStatement(animals[7], Animals.eat, animals[12]),
            model.createStatement(animals[12], Animals.eatenBy, animals[7])
        };
    }
}
