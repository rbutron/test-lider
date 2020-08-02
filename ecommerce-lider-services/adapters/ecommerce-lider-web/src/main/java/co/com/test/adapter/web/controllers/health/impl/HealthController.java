package co.com.test.adapter.web.controllers.health.impl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapter.web.controllers.health.IHealthController;
import co.com.test.adapter.web.mapper.StatusTransaction;
import co.com.test.utility.ConstantManagers;
import co.com.test.utility.WebAdapter;
import reactor.core.publisher.Mono;

@WebAdapter
public class HealthController implements IHealthController {

	@Override
	public Mono<ServerResponse> health(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(new StatusTransaction(ConstantManagers.MSG_HEALTH, HttpStatus.OK)));
	}

}
