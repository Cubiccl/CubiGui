package fr.cubi.cubigui.ui;

import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for buttons. */
public class CButtonUI extends BasicButtonUI
{

	@Override
	public void update(Graphics g, JComponent c)
	{
		if (!((AbstractButton) c).getModel().isEnabled()) c.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
		else if (((AbstractButton) c).getModel().isPressed()) c.setBackground(DisplayUtils.getColor(DisplayUtils.CLICKED_COLOR));
		else if (((AbstractButton) c).getModel().isRollover()) c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		else c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		super.update(g, c);
	}

}
