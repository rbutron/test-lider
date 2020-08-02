package co.com.test.repositories.mongodb.config;

import org.springframework.data.mongodb.core.query.Query;

import reactor.core.publisher.Flux;

public interface IPersistenceMongoManager<T> {
	
	Flux<T> listObject(Query query, Class<T> clazz);

}
