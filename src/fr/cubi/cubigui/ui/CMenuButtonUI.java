package fr.cubi.cubigui.ui;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicMenuItemUI;

import fr.cubi.cubigui.DisplayUtils;

public class CMenuButtonUI extends BasicMenuItemUI
{

	@Override
	public void installUI(JComponent c)
	{
		super.installUI(c);
		c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));

		UIUpdater updater = new UIUpdater();
		c.addAncestorListener(updater);
		c.addMouseListener(updater);
		c.addPropertyChangeListener("enabled", updater);
	}

}
