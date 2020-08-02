package co.com.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import co.com.test.adapter.web.mapper.StatusTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EcommerceLiderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(profiles = "dev")
public class RestTest {

	@Autowired
	private WebTestClient webClient;

	private String path = "ecommerce-lider-api/v1/trigger/products";
	private String patHealth = "ecommerce-lider-api/v1/trigger/health";

	@Test
	public void healthTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(patHealth).build()).exchange().expectStatus()
				.isOk();

	}

	@Test
	public void findProductDescriptionTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("query", "urgsh jtiwis").build()).exchange()
				.expectStatus().isOk();

	}

	@Test
	public void findProductIdTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("query", "5").build()).exchange()
				.expectStatus().isOk();

	}

	@Test
	public void findProductIdErrorTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("query", "5*").build()).exchange()
				.expectStatus().is4xxClientError();

	}

	@Test
	public void findProductQueryErrorTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("querys", "5*").build()).exchange()
				.expectStatus().is4xxClientError();

	}

	@Test
	public void findProductQueryEmptyErrorTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("", "5*").build()).exchange().expectStatus()
				.is4xxClientError();

	}

	@Test
	public void findProductObjectTest() {

		StatusTransaction st = new StatusTransaction("", HttpStatus.INTERNAL_SERVER_ERROR);
		assertNotNull(st);

	}

	@Test
	public void findProductPalindromeIdTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("query", "555").build()).exchange()
				.expectStatus().isOk();

	}

	@Test
	public void findProductPalindromeDesTest() {

		webClient.get().uri(uriBuilder -> uriBuilder.path(path).queryParam("query", "adda").build()).exchange()
				.expectStatus().isOk();

	}

}
