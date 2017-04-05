package fr.cubi.cubigui.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JComponent;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import fr.cubi.cubigui.DisplayUtils;

/** Updates a component's background color. */
public class UIUpdater extends MouseAdapter implements PropertyChangeListener, AncestorListener
{
	private boolean isMouseIn = false, isMousePressed = false, isEnabled = true;

	@Override
	public void ancestorAdded(AncestorEvent e)
	{
		JComponent c = (JComponent) e.getComponent();
		if (!c.isEnabled()) return;
		c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		c.repaint();
	}

	@Override
	public void ancestorMoved(AncestorEvent e)
	{}

	@Override
	public void ancestorRemoved(AncestorEvent e)
	{}

	private void defaultColor(JComponent c)
	{
		if (!this.isEnabled) c.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
		else if (this.isMousePressed) c.setBackground(DisplayUtils.getColor(DisplayUtils.CLICKED_COLOR));
		else if (this.isMouseIn) c.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
		else c.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		c.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		this.isMouseIn = true;
		super.mouseExited(e);
		this.defaultColor((JComponent) e.getComponent());
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		this.isMouseIn = false;
		super.mouseExited(e);
		this.defaultColor((JComponent) e.getComponent());
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		this.isMousePressed = true;
		super.mouseExited(e);
		this.defaultColor((JComponent) e.getComponent());
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		this.isMousePressed = false;
		super.mouseExited(e);
		this.defaultColor((JComponent) e.getComponent());
	}

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		this.isEnabled = (boolean) e.getNewValue();
		this.defaultColor((JComponent) e.getSource());
	}
}
