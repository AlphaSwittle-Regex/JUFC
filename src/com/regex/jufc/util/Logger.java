package com.regex.jufc.util;

import com.regex.jufc.time.Timestamp;

public abstract class Logger
{
	public static enum LogLevel
	{
		INFO, SEVERE, CONFIG, FINE, ALL
	}

	private String user;

	public Logger(String user)
	{
		this.user = user;
	}

	public String getUser()
	{
		return user;
	}

	public void setUser(String user)
	{
		this.user = user;
	}

	public void log(LogLevel level, String message)
	{
		System.out.println(Timestamp.getFormattedTimestamp() + " " + getUser() + "/" + level + " : " + message);
	}
}