package com.regex.jufc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileOperation
{
	public static boolean moveFile(String sourceFile, String destFolder)
	{
		boolean flag = false;

		File src = new File(sourceFile);
		File dest = new File(destFolder);

		if (!src.exists())
		{
			try
			{
				throw new IOException("Source file doesn't exist !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (!dest.isDirectory())
		{
			try
			{
				throw new IOException("File destination is not a folder !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (!dest.exists())
		{
			dest.mkdirs();
		}

		try
		{
			Files.move(src.toPath(), dest.toPath(), StandardCopyOption.ATOMIC_MOVE);
			flag = true;
		} catch (IOException e)
		{
			System.out.println("Could not move the file " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean copyFile(String sourceFile, String destFolder)
	{
		boolean flag = false;

		File src = new File(sourceFile);
		File dest = new File(destFolder);

		if (!src.exists())
		{
			try
			{
				throw new IOException("Source file doesn't exist !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (!dest.isDirectory())
		{
			try
			{
				throw new IOException("File destination is not a folder !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (!dest.exists())
		{
			dest.mkdirs();
		}

		try
		{
			Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.ATOMIC_MOVE);
			flag = true;
		} catch (IOException e)
		{
			System.out.println("Could not copy the file " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteFile(String sourceFile)
	{
		boolean flag = false;

		File src = new File(sourceFile);

		if (!src.exists())
		{
			try
			{
				throw new IOException("Source file doesn't exist !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			Files.delete(src.toPath());
			flag = true;
		} catch (IOException e)
		{
			System.out.println("Could not delete the file " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean unzipFile(String zipFile, String outputFolder)
	{
		boolean flag = false;

		File src = new File(zipFile);

		if (!src.exists())
		{
			try
			{
				throw new IOException("Source file doesn't exist !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		byte[] buffer = new byte[1024];

		try
		{
			File folder = new File(outputFolder);
			if (!folder.exists())
			{
				folder.mkdirs();
			}

			ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
			ZipEntry ze = zis.getNextEntry();

			while (ze != null)
			{

				String fileName = ze.getName();
				File newFile = new File(outputFolder + File.separator + fileName);

				new File(newFile.getParent()).mkdirs();

				FileOutputStream fos = new FileOutputStream(newFile);

				int len;
				while ((len = zis.read(buffer)) > 0)
				{
					fos.write(buffer, 0, len);
				}

				fos.close();
				ze = zis.getNextEntry();
			}

			zis.closeEntry();
			zis.close();

			flag = true;

		} catch (IOException ex)
		{
			ex.printStackTrace();
		}

		return flag;
	}
}