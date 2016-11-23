package fr.cubi.cubigui;

import java.awt.Color;

import javax.swing.JTextArea;

/** A several-lines label. */
public class CTextArea extends JTextArea
{
	private static final long serialVersionUID = -2748415360656002559L;

	public CTextArea(String text)
	{
		super(text);
		this.setEditable(false);
		this.setBackground(null);
	}

	@Override
	public void setEditable(boolean b)
	{
		super.setEditable(b);
		if (b)
		{
			this.setBackground(Color.WHITE);
			this.setBorder(new RoundedCornerBorder(true));
		} else
		{
			this.setBackground(null);
			this.setBorder(null);
		}

	}

}
