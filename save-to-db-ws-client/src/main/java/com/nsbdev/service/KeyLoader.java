package com.nsbdev.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

import com.nsbdev.service.exception.ServiceException;
import com.nsbdev.utils.PathUtils;

public class KeyLoader {

	private Path keyFilePath;
	private byte[] encodedKey;

	public KeyLoader(String keyFilePath) {
		this.keyFilePath = PathUtils.buildPathFromString(keyFilePath);
		loadKey();
	}

	public KeyLoader(Path keyFilePath) {
		this.keyFilePath = keyFilePath;
		loadKey();
	}

	private void loadKey() {
		File keyFile = new File(keyFilePath.toString());
		FileInputStream fis;
		try {

			fis = new FileInputStream(keyFile);
			encodedKey = new byte[(int) keyFile.length()];
			fis.read(encodedKey);
			fis.close();

		} catch (IOException e) {
			throw new ServiceException("cant load key", e);
		}

	}

	public byte[] getEncodedKey() {
		return encodedKey;
	}
}
