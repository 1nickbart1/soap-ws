package com.nsbdev.main;

import com.nsbdev.service.KeyPairGeneratorService;
import com.nsbdev.service.KeySaverService;

public class Main {
	public static void main(String[] args) {
		KeyPairGeneratorService keyGenService = new KeyPairGeneratorService();
		KeySaverService saver = new KeySaverService(keyGenService.getPrivateKey(), keyGenService.getPublicKey());
		saver.saveKeys();
	}

}
