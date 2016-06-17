package com.nsbdev.service;

import javax.xml.ws.Endpoint;

import com.nsbdev.ws.DataSaverWs;
import com.nsbdev.ws.DataSaverWsImpl;

public class WsStarter {
	private static final String port = "8080";

	private static final String wsName = "saver";

	public static void startWs() {
		StringBuilder address = new StringBuilder();
		address.append("http://localhost:").append(port).append("/").append(wsName);
		System.out.println(address);
		DataSaverWs dataSaver = new DataSaverWsImpl();
		Endpoint endpoint = Endpoint.publish(address.toString(), dataSaver);
		System.out.println("start ws " + endpoint.isPublished());
	}

}
