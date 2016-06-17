package com.nsbdev.service;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import com.nsbdev.service.exception.ServiceException;

public class KeyGenerator {
	private byte[] encodedKey;
	private PublicKey publicKey;

	public KeyGenerator(byte[] encodedKey) {
		this.encodedKey = encodedKey;
		generateKey();
	}

	private void generateKey() {

		KeyFactory keyFactory;
		try {

			keyFactory = KeyFactory.getInstance("DSA", "SUN");
			X509EncodedKeySpec  publicKeySpec = new X509EncodedKeySpec  (encodedKey);
			publicKey = keyFactory.generatePublic(publicKeySpec);

		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException e) {
			throw new ServiceException("cant generate key", e);
		}

	}
	
	public PublicKey getPublicKey(){
		return publicKey;
	}

}
