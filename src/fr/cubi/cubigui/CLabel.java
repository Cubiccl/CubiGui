package fr.cubi.cubigui;

import javax.swing.JLabel;

/** A Custom Label. */
public class CLabel extends JLabel
{
	private static final long serialVersionUID = 5974963322978871539L;

	public CLabel(String text)
	{
		super(text);
		this.setFont(DisplayUtils.FONT);
	}

}
