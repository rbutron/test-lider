package co.com.test.application.ports.in;

import co.com.test.domains.TestProductModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestProductFind {
	
	Flux<TestProductModel> findDescription(Mono<String> description);
	
	Flux<TestProductModel> findIdentification(Mono<Integer> id);

}
