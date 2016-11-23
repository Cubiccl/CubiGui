package fr.cubi.cubigui;

import java.awt.Font;

import javax.swing.JMenuItem;

import fr.cubi.cubigui.ui.CButtonUI;

/** A Custom MenuItem. */
public class CMenuItem extends JMenuItem
{
	private static final long serialVersionUID = 7525223427463117L;

	public CMenuItem(String name)
	{
		super(name);
		this.setFont(DisplayUtils.FONT.deriveFont(Font.BOLD, 12));
		this.setBorderPainted(true);
		this.setUI(new CButtonUI());
	}

}
