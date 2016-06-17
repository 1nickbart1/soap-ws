package com.nsbdev.service;

import java.net.HttpURLConnection;
import java.net.URL;

public class WsAnalyzer {

	private static String WSDL_URL = "http://localhost:8080/saver?wsdl";

	public static boolean isStart() {
		HttpURLConnection connection = null;
		try {
			URL url = new URL(WSDL_URL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("HEAD");
			connection.getInputStream();
			return connection.getResponseCode() == 200;
		} catch (Exception e) {
			return false;
		} finally {
			if (connection != null)
				connection.disconnect();
		}
	}
}
