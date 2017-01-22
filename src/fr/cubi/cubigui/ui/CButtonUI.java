package fr.cubi.cubigui.ui;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for buttons. */
public class CButtonUI extends BasicButtonUI
{

	@Override
	public void installUI(JComponent c)
	{
		super.installUI(c);
		c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		
		UIUpdater updater = new UIUpdater();
		c.addMouseListener(updater);
		c.addPropertyChangeListener("enabled", updater);
	}

}
