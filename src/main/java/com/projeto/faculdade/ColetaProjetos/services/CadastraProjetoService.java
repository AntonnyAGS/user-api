package com.projeto.faculdade.ColetaProjetos.services;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.projeto.faculdade.ColetaProjetos.config.swagger.ConnectionMongoDBConfig;
import com.projeto.faculdade.ColetaProjetos.model.ProjetoModelRequest;
import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraProjetoInterface;

/**
 * Classe responsável por conter a implementação do método
 * contrato da aplicação para o cadastro de um cliente
 *
 * @author João Vitor
 * @since 09/11/2020
 */
public class CadastraProjetoService implements CadastraProjetoInterface {

    @Autowired
    private ConnectionMongoDBConfig connectionMongoDBConfig;

    @Override
    public void cadastrarProjeto(ProjetoModelRequest projetoModel) {
    	
        MongoClient mongoClient = connectionMongoDBConfig.connectionMongoConfig();
        MongoDatabase projeto = mongoClient.getDatabase("Projeto");
        MongoCollection<Document> collectionCliente = projeto.getCollection("CollectionProjeto");
        
        Document document = new Document();
        document.append("projeto", projetoModel.getProjeto());

        collectionCliente.insertOne(document);
    }
}
