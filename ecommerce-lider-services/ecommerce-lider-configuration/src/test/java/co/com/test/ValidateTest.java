package co.com.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import co.com.test.utility.ValidateQuery;

public class ValidateTest {
	
	@Test
	public void validateTest() {
		assertNotNull(ValidateQuery.responsabity("s"));
	}
	
	@Test
	public void validate1Test() {
		assertNotNull(ValidateQuery.responsabity("5"));
	}

}
