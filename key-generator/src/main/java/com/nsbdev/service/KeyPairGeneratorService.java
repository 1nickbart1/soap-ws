package com.nsbdev.service;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;

public class KeyPairGeneratorService {

	private static final String KEY_ALG = "DSA";

	private static final String KEY_PROVIDER = "SUN";

	private static final String SECURE_ALG = "SHA1PRNG";

	private PrivateKey privateKey;
	private PublicKey publicKey;

	public KeyPairGeneratorService() {
		super();
		generate();
	}

	public PrivateKey getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	} 

	public PublicKey getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(PublicKey publicKey) {
		this.publicKey = publicKey;
	}

	private void generate() {

		try {
			KeyPairGenerator keyGen = KeyPairGenerator.getInstance(KEY_ALG, KEY_PROVIDER);
			SecureRandom random = SecureRandom.getInstance(SECURE_ALG, KEY_PROVIDER);
			keyGen.initialize(1024, random);
			KeyPair pair = keyGen.generateKeyPair();
			privateKey = pair.getPrivate();
			publicKey = pair.getPublic();

		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			throw new RuntimeException("cant create keys", e);
		}

	}

}
