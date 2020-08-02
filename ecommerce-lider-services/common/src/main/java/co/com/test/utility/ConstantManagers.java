package co.com.test.utility;

public class ConstantManagers {

	public static final String ENVAPP = "${app.env}";

	public static final String APPNAME = "/ecommerce-lider-api/";
	public static final String TRIGGERPATH = APPNAME.concat("v1/trigger/products");
	public static final String HEALTHPATH = APPNAME.concat("v1/trigger/health");

	public static final String MONGO_ID = "id";
	public static final String MONGO_BRAND = "brand";
	public static final String MONGO_DESCRIPTION = "description";
	public static final String MONGO_IMAGE = "image";
	public static final String MONGO_PRICE = "price";
	public static final String MONGO_LIKE = ".*%s.*";

	public static final String QUERY_PARAM_NAME = "query";

	public static final String EMPTY = "";
	public static final String EVALUATE_DATA_QUERY = "^[a-zA-Z0-9 ñÑ]{1,20}$";
	public static final String EVALUATE_DATA_STRING = "\\s+";

	public static final String MSG_HEALTH = "Eureka!!";
	public static final String MSG_ERROR_QUERY = "No ingreso correctamente el parametro";
	public static final String MSG_ERROR_QUERY_ACCESS = "El argumento dentro del Query no se esta enviando correctamente";


	private ConstantManagers() {
	}
}
