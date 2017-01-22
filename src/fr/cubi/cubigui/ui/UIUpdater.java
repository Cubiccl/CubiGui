package fr.cubi.cubigui.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;

import fr.cubi.cubigui.DisplayUtils;

public class UIUpdater extends MouseAdapter implements PropertyChangeListener
{

	@Override
	public void mouseEntered(MouseEvent e)
	{
		super.mouseExited(e);
		JComponent c = (JComponent) e.getComponent();
		if (!c.isEnabled()) return;
		c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		c.repaint();
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		super.mouseExited(e);
		JComponent c = (JComponent) e.getComponent();
		if (!c.isEnabled()) return;
		c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		c.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		super.mouseExited(e);
		JComponent c = (JComponent) e.getComponent();
		if (!c.isEnabled()) return;
		c.setBackground(DisplayUtils.getColor(DisplayUtils.CLICKED_COLOR));
		c.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		super.mouseExited(e);
		JComponent c = (JComponent) e.getComponent();
		if (!c.isEnabled()) return;
		c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		c.repaint();
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		JComponent c = (JComponent) e.getSource();
		if ((boolean) e.getNewValue())
		{
			c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
			c.repaint();
		} else
		{
			c.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
			c.repaint();
		}
	}
}
