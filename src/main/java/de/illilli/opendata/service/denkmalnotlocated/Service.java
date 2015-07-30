package de.illilli.opendata.service.denkmalnotlocated;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	HttpServletRequest request;

	@Context
	HttpServletResponse response;

	/**
	 * <p>
	 * <a href="http://localhost:8080/denkmalnotlocated/service">/
	 * denkmalnotlocated/service</a>
	 * </p>
	 * 
	 * @param denkmalAsJsonString
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String setDenkmalInError(String denkmalAsJsonString) {
		// response.setCharacterEncoding("UTF-8");
		Gson gson = new Gson();
		Denkmal denkmal = gson.fromJson(denkmalAsJsonString,
				new Denkmal().getClass());
		DenkmalNotLocated denkmalNotLocated = new DenkmalNotLocated(denkmal);
		return new Gson().toJson(denkmalNotLocated.getDenkmalList());
	}

	/**
	 * <p>
	 * <a href="http://localhost:8080/denkmalnotlocated/service/notlocated">/
	 * denkmalnotlocated/service/notlocated</a>
	 * </p>
	 * 
	 * @param denkmalAsJsonString
	 * @return
	 * @throws IOException
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/notlocated")
	public String getDenkmalInError() throws IOException {
		response.setCharacterEncoding("UTF-8");
		String json = "";
		boolean fromResource = request.getParameter("res") != null ? true
				: false;
		if (fromResource) {
			InputStream inputStream = this.getClass().getResourceAsStream(
					"/denkmalnotlocated.json");
			json = IOUtils.toString(inputStream, "UTF-8");
		} else {
			json = new Gson().toJson(new DenkmalNotLocated().getDenkmalList());
		}
		return json;
	}

}
