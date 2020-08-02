package co.com.test.utility;

import java.util.Objects;

public class ValidateQuery {

	public static boolean responsabity(String txt) {
		boolean aux = true;
		if (Objects.nonNull(txt)) {
			try {
				Integer.parseInt(txt);
				aux = false;
			} catch (NumberFormatException nfe) {
				aux = true;
			}
		}
		return aux;
	}

	private ValidateQuery() {
	}

}
