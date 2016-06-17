package com.nsbdev.service;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;

import com.nsbdev.properties.Property;
import com.nsbdev.service.exception.ServiceException;
import com.nsbdev.utils.StringUtils;

public class SignatureValidator {
	private String textToValidate;
	private byte[] signToValidate;
	private boolean resultOfValidation;

	public SignatureValidator(String textToValidate, byte[] signToValidate) {
		this.textToValidate = textToValidate;
		this.signToValidate = signToValidate;
	}

	public SignatureValidator(String textToValidate, String signToValidate) {
		this.textToValidate = textToValidate;
		this.signToValidate = StringUtils.convertStringToByteMas(signToValidate);
	}

	public void validateText() {

		try {

			Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
			
			PublicKey publicKey = getPublicKey();
			sig.initVerify(publicKey);
			byte[] bytesToSign = textToValidate.getBytes(StandardCharsets.UTF_8);
			sig.update(bytesToSign);
			resultOfValidation = sig.verify(signToValidate);
			
		} catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException e) {
			throw new ServiceException("error in validating", e);
		}

	}

	private PublicKey getPublicKey() {
		Path pathToKey = Property.getPropery().getRealPathToKey();

		KeyLoader keyLoader = new KeyLoader(pathToKey);
		KeyGenerator keyGenerator = new KeyGenerator(keyLoader.getEncodedKey());
		PublicKey publicKey = keyGenerator.getPublicKey();

		return publicKey;
	}

	public boolean getResultOfValidation() {
		return resultOfValidation;
	}


}
