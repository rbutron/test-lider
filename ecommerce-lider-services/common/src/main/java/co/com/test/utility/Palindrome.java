package co.com.test.utility;

import java.util.stream.IntStream;

public class Palindrome {

	public static boolean is(String txt) {
		String tmp = txt.replaceAll(ConstantManagers.EVALUATE_DATA_STRING, ConstantManagers.EMPTY).toLowerCase();
		return IntStream.range(0, tmp.length() / 2).noneMatch(i -> tmp.charAt(i) != tmp.charAt(tmp.length() - i - 1));
	}

	private Palindrome() {
	}

}
