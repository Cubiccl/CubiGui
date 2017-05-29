package fr.cubi.cubigui;

import java.awt.Font;

import javax.swing.JMenu;

import fr.cubi.cubigui.ui.CMenuButtonUI;

public class CMenu extends JMenu
{
	private static final long serialVersionUID = -4831778936672994814L;

	public CMenu(String name)
	{
		super(name);
		this.setFont(DisplayUtils.FONT.deriveFont(Font.BOLD, 12));
		// this.setBorderPainted(true);
		this.setUI(new CMenuButtonUI());
	}

}
