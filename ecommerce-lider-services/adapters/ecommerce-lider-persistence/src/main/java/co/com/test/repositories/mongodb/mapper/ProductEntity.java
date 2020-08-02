package co.com.test.repositories.mongodb.mapper;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Document(collection = "products")
public class ProductEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1304819065565938096L;
	
	@Id
	private String idMongo;
	
	private Integer id;
	private String brand;
	private String description;
	private String image;
	private Integer price;
	

}
