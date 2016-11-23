package fr.cubi.cubigui;

import javax.swing.JCheckBox;

import fr.cubi.cubigui.ui.CCheckBoxUI;

/** A Custom CheckBox. */
public class CCheckBox extends JCheckBox
{
	private static final long serialVersionUID = 5104176511435068723L;

	public CCheckBox(String text)
	{
		super(text);
		this.setUI(new CCheckBoxUI());
		this.setBorder(new RoundedCornerBorder());
		this.setBorderPainted(true);
		this.setFont(DisplayUtils.FONT);
	}

}
