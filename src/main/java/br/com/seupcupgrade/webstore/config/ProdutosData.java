package br.com.seupcupgrade.webstore.config;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;


import java.util.Arrays;

import static br.com.seupcupgrade.webstore.constants.ProdutoConstants.ENDPOINT_DYNAMO;
import static br.com.seupcupgrade.webstore.constants.ProdutoConstants.REGION_DYNAMO;

public class ProdutosData {

    public static void main(String[] args) throws Exception{

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO,REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("NProdutos_Table");

        PutItemOutcome outcome;


        Item produto1 = new Item()
                .withPrimaryKey("id",1L)
                .withString("prd_titulo", "Placa de Vídeo NVIDIA gtx 1050")
                .withString("prd_fabricante", "NVIDIA")
                .withDouble("prd_preco", 2240.0)
                .withDouble("prd_precoaqusicao",880)
                .withInt("prd_qtestoque", 4)
                .withString("prd_descricao", "Placa de Vídeo Asus NVIDIA " +
                        "GeForce GTX 1050 Ti OC Cerberus 4GB, GDDR5 - CERBERUS-GTX1050TI-O4G");
            outcome = table.putItem(produto1);



        Item produto2 = new Item()
                .withPrimaryKey("id",2L)
                .withString("prd_titulo", "HyperX 8GB de RAM DDR4 Gaming")
                .withString("prd_fabricante", "HyperX")
                .withDouble("prd_preco", 358.0)
                .withDouble("prd_precoaqusicao",123.0)
                .withInt("prd_qtestoque", 30)
                .withString("prd_descricao", "HyperX 8GB de RAM DDR4 Gaming - Velocidades até 4133MHz");

        outcome = table.putItem(produto2);

        Item produto3 = new Item()
                .withPrimaryKey("id",3L)
                .withString("prd_titulo", "Processador AMD Ryzen 5 3600 Cache 32MB 3.6GHz AM4")
                .withString("prd_fabricante", "AMD Ryzen")
                .withDouble("prd_preco", 3459.0)
                .withDouble("prd_precoaqusicao",2250.0)
                .withInt("prd_qtestoque", 15)
                .withString("prd_descricao", "Processador AMD Ryzen 5 3600 Cache 32MB 3.6GHz AM4");

        outcome = table.putItem(produto3);



    }

}
