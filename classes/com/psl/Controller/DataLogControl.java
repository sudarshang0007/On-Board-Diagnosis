package com.psl.Controller;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.psl.Bean.DataLog;
import com.psl.Bean.LogDbWrite;


@Path("/log")
public class DataLogControl {

	static DataLog dl=null;

	@GET
	@Path("/set")
	@Consumes({"application/x-www-form-urlencoded","text/plain","multipart/form-data"})
	public Response sendreinfo(
			@QueryParam("kff1005") float Lattitude, 
			@QueryParam("kff1006") float Longitude,
			@QueryParam("kff1001") float GPSspeed,
			@QueryParam("kc") float RPM, 
			@QueryParam("kd") float OBDspeed,
			@QueryParam("kff1204") float TripDist
			){

		//assigned values to DataLog object
		DataLog Log=new DataLog(Lattitude, Longitude, GPSspeed, RPM, OBDspeed,TripDist);
		dl=Log;
		// write data to Database *not implemented yet
		LogDbWrite.WriteToDB(dl);

		return Response.ok().header("access-control-allow-origin", "*")
				.header("Access-Control-Allow-Methods","GET, POST")
				.header("Access-Control-Allow-Methods", "Origin, Content-Type, Accept, Authorization, X-Request-With")
				.header("Access-Control-Allow-Methods", "true")
				.entity(dl.toString())
				.build();
	}


	@GET
	@Path("/get")
	@Produces("application/json")
	@Consumes({"application/x-www-form-urlencoded","text/plain","multipart/form-data"})
	public Response geo(){

		// Map for 
		Map<String, DataLog> map=new HashMap<>();
		map.put("data", dl);
		return Response.ok()
				.header("access-control-allow-origin", "*")
				.header("Access-Control-Allow-Methods","GET, POST")
				.header("Access-Control-Allow-Methods", "Origin, Content-Type, Accept, Authorization, X-Request-With")
				.header("Access-Control-Allow-Methods", "true")
				.entity(map)
				.build();
	}


}

