package co.com.test.adapter.web.controllers.health;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface IHealthController {

	Mono<ServerResponse> health(ServerRequest request);

}
