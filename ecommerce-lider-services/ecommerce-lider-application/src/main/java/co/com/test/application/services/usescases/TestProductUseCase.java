package co.com.test.application.services.usescases;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.test.application.ports.in.TestProductFind;
import co.com.test.application.ports.out.TestProduct;
import co.com.test.domains.TestProductModel;
import co.com.test.utility.ConstantManagers;
import co.com.test.utility.Palindrome;
import co.com.test.utility.UseCase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@UseCase
public class TestProductUseCase implements TestProductFind {

	@Autowired
	private TestProduct<TestProductModel> manager;

	@Override
	public Flux<TestProductModel> findDescription(Mono<String> description) {

		return description.flatMapMany(m -> Palindrome.is(m) ? manager.listObjectDescription(m).flatMap(d -> {
			var price = (int) (d.getPriceElement() * 0.5);
			d.setDiscountElement(price);
			return Mono.just(d);
		}) : manager.listObjectDescription(m));
	}

	@Override
	public Flux<TestProductModel> findIdentification(Mono<Integer> id) {
		return id.flatMapMany(
				m -> m >= 100 && Palindrome.is(m + ConstantManagers.EMPTY) ? manager.listObjectID(m).flatMap(d -> {
					var price = (int) (d.getPriceElement() * 0.5);
					d.setDiscountElement(price);
					return Mono.just(d);
				}) : manager.listObjectID(m));
	}

}
