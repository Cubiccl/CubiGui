package fr.cubi.cubigui;

import javax.swing.JRadioButton;

import fr.cubi.cubigui.ui.CCheckBoxUI;

/** A custom Radio Button. */
public class CRadioButton extends JRadioButton
{
	private static final long serialVersionUID = 6105492383185669037L;

	public CRadioButton(String text)
	{
		super(text);
		this.setUI(new CCheckBoxUI());
		this.setBorder(new RoundedCornerBorder());
		this.setBorderPainted(true);
		this.setFont(DisplayUtils.FONT);
	}

}
