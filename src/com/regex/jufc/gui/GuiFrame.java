package com.regex.jufc.gui;

import java.awt.Image;

import javax.swing.JFrame;

public class GuiFrame extends JFrame
{
	private static final long serialVersionUID = 8852779738403682667L;

	public GuiFrame(String title, Image icon)
	{
		super(title);
		this.setIconImage(icon);
	}
}
