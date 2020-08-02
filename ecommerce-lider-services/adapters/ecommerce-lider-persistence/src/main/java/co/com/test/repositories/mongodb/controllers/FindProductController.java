package co.com.test.repositories.mongodb.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.test.application.ports.out.TestProduct;
import co.com.test.domains.TestProductModel;
import co.com.test.repositories.mongodb.config.IPersistenceMongoManager;
import co.com.test.repositories.mongodb.mapper.ProductEntity;
import co.com.test.repositories.mongodb.query.TestQuery;
import co.com.test.utility.PersistenceAdapter;
import reactor.core.publisher.Flux;

@PersistenceAdapter
public class FindProductController implements TestProduct<TestProductModel> {

	@Autowired
	private IPersistenceMongoManager<ProductEntity> manager;

	@Override
	public Flux<TestProductModel> listObjectID(Integer id) {
		return manager.listObject(TestQuery.findProductID(id), ProductEntity.class)
				.map(m -> TestProductModel.builder().identification(m.getId()).brandElement(m.getBrand())
						.priceElement(m.getPrice()).imageElement(m.getImage()).descriptionElement(m.getDescription())
						.build());
	}

	@Override
	public Flux<TestProductModel> listObjectDescription(String description) {
		return manager.listObject(TestQuery.findProductDescription(description), ProductEntity.class)
				.map(m -> TestProductModel.builder().identification(m.getId()).brandElement(m.getBrand())
						.priceElement(m.getPrice()).imageElement(m.getImage()).descriptionElement(m.getDescription())
						.build());
	}
}
