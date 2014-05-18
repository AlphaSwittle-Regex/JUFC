package com.regex.jufc.gui.componant;

import java.awt.Color;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class GuiComponant
{
	public static class GuiButton extends JButton
	{
		private static final long serialVersionUID = 1383298531896660978L;

		public GuiButton(String text, Icon icon)
		{
			super(text, icon);
		}
	}

	public static class GuiTextField extends JTextField
	{
		private static final long serialVersionUID = 1383298531896660978L;

		public GuiTextField(int columns, Color background, Color foreground)
		{
			super(columns);
			this.setBackground(background);
			this.setForeground(foreground);
		}
	}

	public static class GuiSlider extends JSlider
	{
		private static final long serialVersionUID = 1383298531896660978L;

		public GuiSlider(int minValue, int maxValue, int currentValue, Color background, Color foreground)
		{
			super(minValue, maxValue, currentValue);
			this.setBackground(background);
			this.setForeground(foreground);
		}
	}

	public static class GuiComboBox extends JComboBox<Object>
	{
		private static final long serialVersionUID = 3836684035286639806L;

		public GuiComboBox(Object[] array)
		{
			super(array);
		}
	}

	public static class GuiCheckBox extends JCheckBox
	{
		private static final long serialVersionUID = 1613996435837560363L;

		public GuiCheckBox(String text, Icon icon, boolean bool)
		{
			super(text, icon, bool);
		}
	}
}