package com.regex.jufc.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FolderOperation
{
	public static boolean copyFolder(String srcFolder, String destFolder)
	{
		boolean flag = false;

		File src = new File(srcFolder);
		File dest = new File(destFolder);

		if (!src.exists() || !src.isDirectory())
		{
			try
			{
				throw new IOException("Source folder doesn't exist or is not a folder !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			Files.copy(src.toPath(), dest.toPath());
			flag = true;
		} catch (IOException e)
		{
			System.out.println("Could not copy the folder " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean moveFolder(String sourceFolder, String destFolder)
	{
		boolean flag = false;

		File src = new File(sourceFolder);
		File dest = new File(destFolder);

		if (!src.exists() || !src.isDirectory())
		{
			try
			{
				throw new IOException("Source folder doesn't exist or is not a folder !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		try
		{
			Files.move(src.toPath(), dest.toPath());
			flag = true;
		} catch (IOException e)
		{
			System.out.println("Could not move the folder " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean deleteFolder(String folderToDelete)
	{
		boolean flag = false;

		File src = new File(folderToDelete);

		if (!src.isDirectory() || !src.exists())
		{
			try
			{
				throw new IOException("The folder to delete doesn't exist or is not a folder !");
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
			System.out.println("Could not delete the folder " + src.getAbsoluteFile() + ":\n");
			e.printStackTrace();
		}

		return flag;
	}

	public static boolean emptyFolder(String sourceFolder)
	{
		boolean flag = false;

		File src = new File(sourceFolder);

		if (!src.exists())
		{
			try
			{
				throw new IOException("Source folder doesn't exist !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		if (!src.isDirectory())
		{
			try
			{
				throw new IOException("Source folder is not a folder !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		File[] files = src.listFiles();

		if (files.length == 0)
		{
			try
			{
				throw new IOException("Source folder is empty !");
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		else
		{
			for (int i = 0; i == files.length; i++)
			{
				try
				{
					Files.delete(files[i].toPath());
					flag = true;
				} catch (IOException e)
				{
					System.out.println("Could not empty the folder " + src.getAbsoluteFile() + ":\n");
					e.printStackTrace();
				}
			}
		}

		return flag;
	}
}