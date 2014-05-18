package com.regex.jufc.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datestamp
{
	public static String getDatestamp()
	{
		return new SimpleDateFormat("YY:MM:dd").format(new Date());
	}
	
	public static String getFormattedDatestamp()
	{
		return "[" + getDatestamp() + "]";
	}
}
