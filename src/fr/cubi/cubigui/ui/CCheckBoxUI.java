package fr.cubi.cubigui.ui;

import javax.swing.AbstractButton;
import javax.swing.JComponent;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicToggleButtonUI;

import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for checkboxes. */
public class CCheckBoxUI extends BasicToggleButtonUI
{

	@Override
	public void installUI(JComponent c)
	{
		super.installUI(c);
		c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		((AbstractButton) c).setIcon(new UncheckedIcon());

		UIUpdater updater = new UIUpdater();
		c.addMouseListener(updater);
		c.addPropertyChangeListener("enabled", updater);
		((JToggleButton) c).addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{
				if (((JToggleButton) e.getSource()).isSelected()) ((AbstractButton) c).setIcon(new CheckedIcon());
				else ((AbstractButton) c).setIcon(new UncheckedIcon());
			}
		});
	}

}
