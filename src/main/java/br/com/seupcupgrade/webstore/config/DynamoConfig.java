package br.com.seupcupgrade.webstore.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

@Configuration
@EnableDynamoDBRepositories
public class DynamoConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String amazonDanymoDBEndpoint;

    @Value("${aws_access_key_id}")
    private String amazonAWSAccesKey;

    @Value("${aws_secret_access_key}")
    private String amazonAWSSecretKey;

    @Bean
    AmazonDynamoDB amazonDynamoDB(){

        AmazonDynamoDB amazonDynamoDB = new AmazonDynamoDBClient(amazonAWSCredentials());

        //amazonDynamoDB.setRegion(Region.getRegion(Regions.US_EAST_1));

        if(!StringUtils.isEmpty(amazonDanymoDBEndpoint)){
            amazonDynamoDB.setEndpoint(amazonDanymoDBEndpoint);
        }

        return amazonDynamoDB;

    }

    @Bean
    AWSCredentials amazonAWSCredentials(){
        return new BasicAWSCredentials(
                amazonAWSAccesKey, amazonAWSSecretKey
        );

    }




}
