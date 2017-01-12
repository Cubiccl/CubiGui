package fr.cubi.cubigui.ui;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.ComboPopup;

import fr.cubi.cubigui.CComboBox;
import fr.cubi.cubigui.DisplayUtils;

/** Custom UI for comboboxes. */
public class CComboboxUI extends BasicComboBoxUI
{
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

	@SuppressWarnings("rawtypes")
	@Override
	public void update(Graphics g, JComponent c)
	{
		if (!((JComboBox) c).isEnabled()) c.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
		else if (((CComboBox) c).isPressed()) c.setBackground(DisplayUtils.getColor(DisplayUtils.CLICKED_COLOR));
		else if (((CComboBox) c).isHovered()) c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		else c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		super.update(g, c);
	}
	
	@Override
	protected ComboPopup createPopup()
	{
		return new CPopup(this.comboBox);
	}

}
