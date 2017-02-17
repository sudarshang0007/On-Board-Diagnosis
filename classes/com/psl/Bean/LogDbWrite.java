package com.psl.Bean;

import com.sun.istack.internal.logging.Logger;

public class LogDbWrite {

	public static void  WriteToDB(DataLog dl){
		Logger log= Logger.getLogger(DataLog.class);
		log.info(dl.toString());
	}
	
	
}
