package com.nsbdev.service;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

import com.nsbdev.service.exception.ServiceException;

public class KeyGenerator {
	private byte[] encodedKey;
	private PrivateKey privateKey;

	public KeyGenerator(byte[] encodedKey) {
		this.encodedKey = encodedKey;
		generateKey();
	}

	private void generateKey() {

		KeyFactory keyFactory;
		try {

			keyFactory = KeyFactory.getInstance("DSA", "SUN");
			PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedKey);
			privateKey = keyFactory.generatePrivate(privateKeySpec);

		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e) {
			throw new ServiceException("cant generate key", e);
		}

	}
	
	public PrivateKey getPrivateKey(){
		return privateKey;
	}

}
