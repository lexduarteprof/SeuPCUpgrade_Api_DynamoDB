package br.com.seupcupgrade.webstore;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class WebstoreApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebstoreApplication.class, args);
		System.out.println("Pagina da WebStore de produtos para PC");
	}

}
