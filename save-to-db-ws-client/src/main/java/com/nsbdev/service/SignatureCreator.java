package com.nsbdev.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;

import com.nsbdev.properties.Property;
import com.nsbdev.service.exception.ServiceException;

public class SignatureCreator {
	private String textToSign;
	byte[] realSig;

	public SignatureCreator(String textToSign) {
		this.textToSign = textToSign;
		signText();
	}

	private void signText() {

		try {

			Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
			PrivateKey privateKey = getPrivateKey();
			dsa.initSign(privateKey);
			byte[] bytesToSign = textToSign.getBytes(StandardCharsets.UTF_8);
			dsa.update(bytesToSign);
			realSig = dsa.sign();
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e) {
			throw new ServiceException("error in signing", e);
		}

	}

	private PrivateKey getPrivateKey() {
		Path pathToKey = Property.getPropery().getRealPathToKey();

		KeyLoader keyLoader = new KeyLoader(pathToKey);
		KeyGenerator keyGenerator = new KeyGenerator(keyLoader.getEncodedKey());
		PrivateKey privateKey = keyGenerator.getPrivateKey();

		return privateKey;
	}
	
	public byte[] getRealSig(){
		return realSig;
	}
	
	public String getStringRealSig(){
//		String stringRealSig = new String(realSig);
		String stringRealSig = Arrays.toString(realSig);
		return stringRealSig;
	}

}
