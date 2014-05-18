package com.regex.jufc.time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp
{
	public static String getTimestamp()
	{
		return new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static String getFormattedTimestamp()
	{
		return "[" + getTimestamp() + "]";
	}
}
