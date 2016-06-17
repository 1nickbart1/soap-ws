package com.nsbdev.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class KeySaverService {
	private PrivateKey privateKey;
	private PublicKey publicKey;

	public KeySaverService(PrivateKey privateKey, PublicKey publicKey) {
		super();
		this.privateKey = privateKey;
		this.publicKey = publicKey;
	}

	public void saveKeys() {
		File privateKeyFile = new File("private_key");
		File publicKeyFile = new File("public_key");

		try {
			privateKeyFile.createNewFile();
			publicKeyFile.createNewFile();
			byte[] key;
			
			key = privateKey.getEncoded();
			FileOutputStream out = new FileOutputStream(privateKeyFile);
			out.write(key);
			out.close();
			
			key = publicKey.getEncoded();
			FileOutputStream out2 = new FileOutputStream(publicKeyFile);
			out2.write(key);
			out2.close();
			
		} catch ( IOException e) {
			throw new RuntimeException("cant save keys",e);
		}
	}

}
