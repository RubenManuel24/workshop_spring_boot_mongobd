package com.ruben.project.workshop.util;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {
	
    public static String decodeParam(String text) {
        try {
            return URLDecoder.decode(text, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
    
    public static Date converDate(String date, Date dateDefault) {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    	try {
			return sdf.parse(date);
		} catch (ParseException e) {
			return dateDefault;
		}
    }
}