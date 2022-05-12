package by.kagan.ticket.api.utils;

import java.util.Arrays;

public class NamingUtils {
	
	public static String fromCamelToSnakeCase(String str) {
		char[] toArr = str.toCharArray();
		
		for (int i = 0; i < toArr.length; i++) {
			if (isInUpperCase(toArr[i])) {
				toArr[i] = Character.toLowerCase(toArr[i]);
				
				for (int j = toArr.length - 1; j >= i; j--) {
					toArr[j+1] = toArr[j];
				}
				
				toArr[i] = '_';
			}
		}
		
		return String.valueOf(toArr);
	}
	
	public static String fromSnakeToCamelCase(String str) {
		return null;
	}
	
	private static boolean isInUpperCase(char c) {
		return c == Character.toUpperCase(c);
	}
}
