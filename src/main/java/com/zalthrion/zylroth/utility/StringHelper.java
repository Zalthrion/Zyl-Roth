package com.zalthrion.zylroth.utility;

public class StringHelper {
	public static String capitalizeFirstLetter(String original) {
		return original.substring(0, 1).toUpperCase() + original.substring(1);
	}
}