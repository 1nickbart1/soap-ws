package com.nsbdev.properties;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Properties;

import com.nsbdev.utils.PathUtils;

public class Property {

	private static Property property = new Property();

	private static final String FILE_NAME = "config.properties";

	private String pathToFileProperty;
	private String pathToKeyProperty;
	private Path realPathToFile;
	private Path realPathToKey;
	private Properties props;
	
	private Property() {
		props = new Properties();
		loadProperties();
		loadPathFromProperties();
		createRealPath();

	}

	private void loadProperties(){
		InputStream stream = null;
		Path path = FileSystems.getDefault().getPath(FILE_NAME);
		
		try {
			stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path.toString());
			props.load(stream);
		} catch (IOException e) {
			throw new RuntimeException("Cant read properties");
		}
	}
	
	
	private void loadPathFromProperties() {
		pathToFileProperty = props.getProperty("pathToFileProperty");
		pathToKeyProperty = props.getProperty("pathToKeyProperty");
	}	

	private void createRealPath() {
		realPathToFile = PathUtils.buildPathFromString(pathToFileProperty);
		realPathToKey = PathUtils.buildPathFromString(pathToKeyProperty);
	}	
	
	public static Property getPropery(){
		return property;
	}
	
	public Path getRealPathToFile(){
		return realPathToFile;
	}
	
	public Path getRealPathToKey(){
		return realPathToKey;
	}

}
