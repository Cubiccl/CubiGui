package fr.cubi.cubigui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicArrowButton;

import fr.cubi.cubigui.ui.CComboboxUI;
import fr.cubi.cubigui.ui.CListCellRenderer;

/** A Custom Combobox. */
public class CComboBox extends JComboBox<String> implements MouseListener
{
	private static final long serialVersionUID = -5586551752242617407L;

	private boolean pressed, hovered;
	/** The values of this combobox. */
	protected String[] values;

	/** Creates a new CComboBox.
	 * 
	 * @param values - The values the user can choose. */
	public CComboBox(String... values)
	{
		super(values);
		this.values = values;
		this.setBorder(new RoundedCornerBorder());
		this.setUI(new CComboboxUI());
		this.setRenderer(new CListCellRenderer());
		for (Component component : this.getComponents())
			if (component instanceof BasicArrowButton) this.remove(component);

		this.addMouseListener(this);
		this.setFont(DisplayUtils.FONT);
	}

	/** @return The selected value. */
	public String getValue()
	{
		return this.values[this.getSelectedIndex()];
	}

	/** @return True if the user is hovering over this Combobox. */
	public boolean isHovered()
	{
		return this.hovered;
	}

	/** @return True if the user is pressing this Combobox. */
	public boolean isPressed()
	{
		return this.pressed;
	}

	@Override
	public void mouseClicked(MouseEvent arg0)
	{}

	@Override
	public void mouseEntered(MouseEvent arg0)
	{
		this.hovered = true;
		this.repaint();
	}

	@Override
	public void mouseExited(MouseEvent arg0)
	{
		this.hovered = false;
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent arg0)
	{
		this.pressed = true;
		this.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		this.pressed = false;
		this.repaint();
	}

	/** Changes the values of this Combobox.
	 * 
	 * @param values - The values the user can choose. */
	public void setValues(String[] values)
	{
		this.values = values;
		int index = this.getSelectedIndex();
		this.setModel(new CComboBox(this.values).getModel());
		if (index > 0 && index < this.values.length) this.setSelectedIndex(index);

		int textWidth = 0;
		for (String value : this.values)
			textWidth = Math.max(DisplayUtils.textWidth(value), textWidth);
		this.setPreferredSize(new Dimension(Math.max(140, textWidth), 27));
	}

}
