package co.com.test.repositories.mongodb.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import co.com.test.repositories.mongodb.config.IPersistenceMongoManager;
import reactor.core.publisher.Flux;

@Repository
public class PersistenceMongoManager<T> implements IPersistenceMongoManager<T> {
	
	@Autowired
	private ReactiveMongoTemplate templateManager;

	@Override
	public Flux<T> listObject(Query query, Class<T> clazz) {
		return templateManager.find(query, clazz);
	}

}
