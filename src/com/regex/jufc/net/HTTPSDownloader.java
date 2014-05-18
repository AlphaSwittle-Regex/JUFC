package com.regex.jufc.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPSDownloader
{
	public static String downloadFile(String fileUrl, String outputFolder, int retries)
	{
		System.setProperty("java.protocol.handler.pkgs", "com.sun.net.ssl.internal.www.protocol");
		String nameForFile = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
		String filename = outputFolder + "/" + nameForFile;

		File folderDest = new File(outputFolder);
		if (!folderDest.exists())
		{
			folderDest.mkdirs();
		}

		while (retries > 0)
		{
			try
			{
				URL url = new URL(fileUrl);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				float totalDataRead = 0;
				BufferedInputStream in = new BufferedInputStream(connection.getInputStream());
				FileOutputStream fos = new FileOutputStream(filename);
				BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
				byte[] data = new byte[1024];
				int i = 0;
				while ((i = in.read(data, 0, 1024)) >= 0)
				{
					totalDataRead = totalDataRead + i;
					bout.write(data, 0, i);
				}
				bout.close();
				in.close();
				retries = 0;
			} catch (IOException e)
			{
				retries--;
				if (retries == 0)
				{
					e.printStackTrace();
				}
			}
		}
		return nameForFile;
	}
}