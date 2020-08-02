package co.com.test.adapter.web.controllers.trigger;

import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

public interface IBridgeController {

	Mono<ServerResponse> find(ServerRequest request);

}