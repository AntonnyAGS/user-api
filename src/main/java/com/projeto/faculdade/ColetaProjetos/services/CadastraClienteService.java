package com.projeto.faculdade.ColetaProjetos.services;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.projeto.faculdade.ColetaProjetos.config.swagger.ConnectionMongoDBConfig;
import com.projeto.faculdade.ColetaProjetos.criptografia.CriptografaDados;
import com.projeto.faculdade.ColetaProjetos.model.ClienteModelRequest;
import com.projeto.faculdade.ColetaProjetos.services.interfaces.CadastraClienteInterface;

/**
 * Classe responsável por conter a implementação do método
 * contrato da aplicação para o cadastro de um cliente
 *
 * @author João Vitor
 * @since 09/11/2020
 */
@Component
public class CadastraClienteService implements CadastraClienteInterface {

    @Autowired
    private ConnectionMongoDBConfig connectionMongoDBConfig;
    
    @Autowired
    private CriptografaDados criptografaDados;

    @Override
    public void cadastrarCliente(ClienteModelRequest clienteModelRequest) {
    	 
    	clienteModelRequest.getUsuario().forEach(usuario -> {
    		String senha = criptografaDados.criptografar(usuario.getPassword());
    		usuario.setPassword(senha);
    	});
    	
        MongoClient mongoClient = connectionMongoDBConfig.connectionMongoConfig();
        MongoDatabase cliente = mongoClient.getDatabase("Cliente");
        MongoCollection<Document> collectionCliente = cliente.getCollection("CollectionCliente");
        
        Document document = new Document();
        document.append("cliente", clienteModelRequest.getUsuario());

        collectionCliente.insertOne(document);
    }
}
