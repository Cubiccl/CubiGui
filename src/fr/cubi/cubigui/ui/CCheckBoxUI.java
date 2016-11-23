package fr.cubi.cubigui.ui;

import java.awt.Graphics;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicCheckBoxUI;

import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for checkboxes. */
public class CCheckBoxUI extends BasicCheckBoxUI
{

	@Override
	public void update(Graphics g, JComponent c)
	{
		if (!((AbstractButton) c).getModel().isEnabled()) c.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
		else if (((AbstractButton) c).getModel().isPressed()) c.setBackground(DisplayUtils.getColor(DisplayUtils.CLICKED_COLOR));
		else if (((AbstractButton) c).getModel().isRollover()) c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		else c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));

		if (((AbstractButton) c).getModel().isSelected()) ((AbstractButton) c).setIcon(new CheckedIcon());
		else ((AbstractButton) c).setIcon(new UncheckedIcon());

		super.update(g, c);
	}

}
