package com.example.tutenlabs.practicaexamenwebservice;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;

public class TimeZone {

	private String time;
	private String timeZone = "UTC";

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public JSONObject dataRetorno(DatosEntrada datosEntrada) {
		JSONObject myObjectResponse = new JSONObject();
		JSONObject myObject = new JSONObject();
		myObject.put("time",parseString(sumarRestarHorasFecha(
				parseDate(datosEntrada.getHora()),Integer.parseInt(datosEntrada.getZonaHoraria()))));
		myObject.put("timezone", timeZone);
		myObjectResponse.put("response", myObject);
		return myObjectResponse;
	}


	public Date parseDate(String time) {
		String myTime = time;
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
	    Date date = null;
	    try {
	        date = sdf.parse(myTime);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	    return date;	    
	}
	
	public String parseString(Date time) {
	    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");	    	    
	    String formattedTime = sdf.format(time);
	    return formattedTime;	    
	}

	public Date sumarRestarHorasFecha(Date fecha, int horas) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(fecha); 
		calendar.add(Calendar.HOUR, horas); 
		return calendar.getTime(); 

	}

}
