package co.com.test.adapter.web.controllers.trigger.impl;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.test.adapter.web.controllers.trigger.IBridgeController;
import co.com.test.adapter.web.mapper.StatusTransaction;
import co.com.test.application.ports.in.TestProductFind;
import co.com.test.domains.TestProductModel;
import co.com.test.utility.ConstantManagers;
import co.com.test.utility.ValidateQuery;
import co.com.test.utility.WebAdapter;
import reactor.core.publisher.Mono;

@WebAdapter
public class BridgeController implements IBridgeController {

	private static final Logger LOGGER = Logger.getLogger(BridgeController.class.getName());

	@Autowired
	private TestProductFind manager;

	@Override
	public Mono<ServerResponse> find(ServerRequest request) {
		var aux = request.queryParam(ConstantManagers.QUERY_PARAM_NAME);
		Mono<ServerResponse> response;
		if (aux.isPresent()) {
			if (Objects.nonNull(aux.get()) && aux.get().matches(ConstantManagers.EVALUATE_DATA_QUERY)) {
				response = ValidateQuery.responsabity(aux.get())
						? ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(manager.findDescription(Mono.just(aux.get())), TestProductModel.class)
								.onErrorResume(e -> {
									LOGGER.log(Level.WARNING, e.getMessage(), e);
									return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
											.contentType(MediaType.APPLICATION_JSON)
											.body(BodyInserters.fromValue(new StatusTransaction(e.getMessage(),
													HttpStatus.INTERNAL_SERVER_ERROR)));
								})
						: ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(manager.findIdentification(Mono.just(Integer.valueOf(aux.get()))),
										TestProductModel.class)
								.onErrorResume(e -> {
									LOGGER.log(Level.WARNING, e.getMessage(), e);
									return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
											.contentType(MediaType.APPLICATION_JSON)
											.body(BodyInserters.fromValue(new StatusTransaction(e.getMessage(),
													HttpStatus.INTERNAL_SERVER_ERROR)));
								});
			} else {
				response = ServerResponse.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
						.body(BodyInserters.fromValue(
								new StatusTransaction(ConstantManagers.MSG_ERROR_QUERY_ACCESS, HttpStatus.CONFLICT)));
			}
		} else {
			response = ServerResponse.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON)
					.body(BodyInserters
							.fromValue(new StatusTransaction(ConstantManagers.MSG_ERROR_QUERY, HttpStatus.CONFLICT)));
		}
		return response;
	}

}