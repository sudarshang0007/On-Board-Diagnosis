package com.psl.Bean;

public final class DataLog {

	public  final float LATTITUDE;
	public  final float LONGITUDE;
	public  final float GPS_SPEED;
	public  final float RPM;
	public  final float OBD_SPEED;
	public  final float TRIP_DIST;


	public DataLog(float lATTITUDE, float lONGITUDE, float gPS_SPEED,float rPM, float oBD_SPEED,float tripdist) {
		LATTITUDE = lATTITUDE;
		LONGITUDE = lONGITUDE;
		GPS_SPEED = gPS_SPEED;
		RPM = rPM;
		OBD_SPEED = oBD_SPEED;
		TRIP_DIST=tripdist;
	}


	@Override
	public String toString() {
		return "DataLog [LATTITUDE=" + LATTITUDE + ", LONGITUDE=" + LONGITUDE
				+ ", GPS_SPEED=" + GPS_SPEED + ", RPM=" + RPM + ", OBD_SPEED="
				+ OBD_SPEED + ", TRIP_DIST=" + TRIP_DIST + "]";
	}	
}
