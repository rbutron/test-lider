package co.com.test.repositories.mongodb.query;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import co.com.test.utility.ConstantManagers;

public class TestQuery {

	public static Query findProductID(Integer id) {
		return Query.query(Criteria.where(ConstantManagers.MONGO_ID).is(id));
	}

	public static Query findProductDescription(String description) {
		return Query.query(new Criteria().orOperator(
				Criteria.where(ConstantManagers.MONGO_DESCRIPTION)
						.regex(String.format(ConstantManagers.MONGO_LIKE, description)),
				Criteria.where(ConstantManagers.MONGO_BRAND)
						.regex(String.format(ConstantManagers.MONGO_LIKE, description))));
	}

	private TestQuery() {
	}

}
