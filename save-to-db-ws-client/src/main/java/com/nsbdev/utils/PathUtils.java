package com.nsbdev.utils;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class PathUtils {

	public static Path buildPathFromString(String stringPath) {
		Path path = FileSystems.getDefault().getPath(stringPath);
	
	   return path;
	}
	
	public static String getFileNameFromPath(Path path){
		String pathInString = path.toString();
		int lastBackSlash =pathInString.lastIndexOf("\\")+1;
		int pathLen = pathInString.length();
		String fileName = pathInString.substring(lastBackSlash, pathLen);
		
		return fileName;
		
		
	}
}
