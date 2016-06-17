package com.nsbdev.utils;

public class ArrayUtils {

	public static byte[] convertStringMasToByteMas(String[] source) {

		byte[] destination = new byte[source.length];
		for (int i = 0; i < destination.length; i++) {
			destination[i] = Byte.valueOf(source[i]);
		}

		return destination;
	}



}
