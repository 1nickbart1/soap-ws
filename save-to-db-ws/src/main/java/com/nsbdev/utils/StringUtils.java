package com.nsbdev.utils;

import java.io.UnsupportedEncodingException;

public class StringUtils {

	public static String removeSpecialSymbols(String source) {

		String destination = source;

		destination = destination.replaceAll("\\Q" + "[" + "\\E", "");
		destination = destination.replaceAll("\\Q" + "]" + "\\E", "");
		destination = destination.replaceAll("\\Q" + " " + "\\E", "");

		return destination;
	}

	public static byte[] convertStringToByteMas(String source) {
		String clearSource = StringUtils.removeSpecialSymbols(source);
		String[] sourceMas = clearSource.split(",");
		byte[] destination = ArrayUtils.convertStringMasToByteMas(sourceMas);

		return destination;

	}
	
	public static byte[] getBytesInCP866(String source){
		byte[] destination;
		try {
			destination = source.getBytes("CP866");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException();
		}
		
		return destination;
		
	}

}
