package co.com.test.domains;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestProductModel {
	
	private Integer identification;
	private Integer priceElement;
	private Integer discountElement;
	private String descriptionElement;
	private String imageElement;
	private String brandElement;

}
