package com.nsbdev.thread;

import com.nsbdev.beans.BLRAPN;
import com.nsbdev.service.DataDbSaver;

public class DataDbSaverThread implements Runnable {
	private BLRAPN blrApn;
	private String key;
	
	
	public DataDbSaverThread(BLRAPN blrApn, String key) {
		super();
		this.blrApn = blrApn;
		this.key = key;
	}

	@Override
	public void run() {	
			new DataDbSaver(blrApn,key).saveToDb();		
	}

	
}
