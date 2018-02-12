/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.GoTOnt.GameOfThronesOntology.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.jena.arq.querybuilder.SelectBuilder;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.springframework.core.io.ClassPathResource;

public class OntologyUtils {

	public static SelectBuilder getBasePrefixes() {
		return new SelectBuilder()
				.addPrefix("ontology",
						"http://www.semanticweb.org/SemanticWeb_UCaldas/2017-2/ontologies/GameOfThrones#")
				.addPrefix("schema", "http://www.w3.org/2000/01/rdf-schema#")
				.addPrefix("syntax", "http://www.w3.org/1999/02/22-rdf-syntax-ns#")
				.addPrefix("owl", "http://www.w3.org/2002/07/owl#");
	}

	public static Model readRDFFile(String path) {
		Model model = ModelFactory.createDefaultModel();

		try {
			File file = new ClassPathResource(path).getFile();
			InputStream ins = new FileInputStream(file);
			model.read(new InputStreamReader(ins), "");
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

		return model;
	}

	public static Query createQueryFromFile(String path) {
		Query query = null;

		try {
			File file = new ClassPathResource(path).getFile();
			String content = readContent(file);
			System.out.println(content);
			query = QueryFactory.create(content);
		} catch (IOException ioex) {
			ioex.printStackTrace();
		}

		return query;
	}

	private static String readContent(File file) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder stringBuilder = new StringBuilder();

		String line;
		while ((line = reader.readLine()) != null) {
			stringBuilder.append(line).append("\n");
		}

		return stringBuilder.toString();
	}
}
