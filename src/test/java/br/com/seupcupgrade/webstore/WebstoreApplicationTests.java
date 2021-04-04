package br.com.seupcupgrade.webstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import static br.com.seupcupgrade.webstore.constants.ProdutoConstants.PRODUTOS_ENDPOINT_LOCAL;
import br.com.seupcupgrade.webstore.repository.ProdutoRepository;




@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class WebstoreApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	ProdutoRepository produtoRepository;



	@Test
	void contextLoads() {
	}

	@Test
	public void getOneProdutoById(){

		webTestClient.get().uri(PRODUTOS_ENDPOINT_LOCAL.concat("/{id}"), 15 )
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	public void GetOneProdutoNotFound(){

		webTestClient.get().uri(PRODUTOS_ENDPOINT_LOCAL.concat("{id}"), 86)
				.exchange()
				.expectStatus().isNotFound();

	}

	public void DeleteProduto(){

		webTestClient.delete().uri(PRODUTOS_ENDPOINT_LOCAL.concat("{id}"), 122)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);
	}


}
