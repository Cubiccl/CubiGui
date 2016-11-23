package fr.cubi.cubigui;

import javax.swing.JButton;

import fr.cubi.cubigui.ui.CButtonUI;

/** A Custom Button. */
public class CButton extends JButton
{
	private static final long serialVersionUID = -4425707045807350000L;

	/** @param text - The text to display. */
	public CButton(String text)
	{
		super(text);
		this.setUI(new CButtonUI());
		this.setBorder(new RoundedCornerBorder());
		this.setFont(DisplayUtils.FONT);
	}

}
