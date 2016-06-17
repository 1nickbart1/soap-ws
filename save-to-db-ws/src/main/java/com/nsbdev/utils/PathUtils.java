package com.nsbdev.utils;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathUtils {

	public static Path buildPathFromString(String stringPath) {
		Path path = FileSystems.getDefault().getPath(stringPath);
	
	   return path;
	}
}
