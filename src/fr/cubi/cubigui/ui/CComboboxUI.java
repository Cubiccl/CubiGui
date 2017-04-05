package fr.cubi.cubigui.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for comboboxes. */
public class CComboboxUI extends BasicComboBoxUI
{
	@Override
	protected ComboPopup createPopup()
	{
		return new CPopup(this.comboBox);
	}

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

	@Override
	public void paintCurrentValue(Graphics g, Rectangle bounds, boolean hasFocus)
	{
		if (this.comboBox.getSelectedItem() != null)
		{
			// Center value
			((CListCellRenderer) this.comboBox.getRenderer()).setPaintingCombobox(true);
			super.paintCurrentValue(g, new Rectangle(bounds.x, bounds.y, this.comboBox.getWidth() - 22, bounds.height), false);
			((CListCellRenderer) this.comboBox.getRenderer()).setPaintingCombobox(false);
		}
	}

}
