package com.regex.jufc.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPDownloader
{
	public static String downloadFile(String fileUrl, String outputFolder, int retries)
	{
		String nameForFile = fileUrl.substring(fileUrl.lastIndexOf('/') + 1);
		String filename = outputFolder + "/" + nameForFile;

		File folderDest = new File(outputFolder);
		if (!folderDest.exists())
		{
			folderDest.mkdirs();
		}

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
		} catch (IOException e)
		{
			System.out.println("Could not download file: \n");
			e.printStackTrace();
		}
		return nameForFile;
	}
}