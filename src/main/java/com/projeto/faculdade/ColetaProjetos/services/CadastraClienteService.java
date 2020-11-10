package com.projeto.faculdade.ColetaProjetos.services;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.projeto.faculdade.ColetaProjetos.config.swagger.ConnectionMongoDBConfig;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;
import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraClienteInterface;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Classe responsável por conter a implementação do método
 * contrato da aplicação para o cadastro de um cliente
 *
 * @author João Vitor
 * @since 09/11/2020
 */
public class CadastraClienteService implements CadastraClienteInterface {

    @Autowired
    private ConnectionMongoDBConfig connectionMongoDBConfig;

    @Override
    public void cadastrarCliente(ClienteModelRequest clienteModelRequest) {

        MongoClient mongoClient = connectionMongoDBConfig.connectionMongoConfig();
        MongoDatabase cliente = mongoClient.getDatabase("Cliente");
        MongoCollection<Document> collectionCliente = cliente.getCollection("CollectionCliente");

        Document document = new Document();
        document.append("cliente", clienteModelRequest.getUsuario());

        collectionCliente.insertOne(document);
    }
}
