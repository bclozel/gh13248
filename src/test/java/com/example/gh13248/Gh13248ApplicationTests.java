package com.example.gh13248;

import org.junit.Test;
import org.junit.runner.RunWith;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Gh13248ApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testUserEndpoint() {

		DemoUser demoUser = webTestClient.post()
				.uri("/user/person")
				.contentType(MediaType.APPLICATION_JSON)
				.body(Mono.just(DemoUser.builder().name("wew").age(22).build()), DemoUser.class)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectBody(DemoUser.class)
				.returnResult()
				.getResponseBody();
		assertThat(demoUser.getName()).isEqualTo("haha");

	}

}
