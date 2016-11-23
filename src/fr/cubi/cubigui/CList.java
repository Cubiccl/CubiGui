package fr.cubi.cubigui;

import java.awt.Dimension;

import javax.swing.JList;

import fr.cubi.cubigui.ui.CListCellRenderer;

/** A Custom List. */
public class CList extends JList<String>
{
	private static final long serialVersionUID = -2372958462361709472L;

	/** @param values - The list of values to display and choose from. */
	public CList(String... values)
	{
		super(values);
		this.setMinimumSize(new Dimension(150, 50));
		this.setBorder(new RoundedCornerBorder(true));
		this.setCellRenderer(new CListCellRenderer());
		this.setUI(new CListUI());
	}

	/** Changes the values of this list.
	 * 
	 * @param values - The list of values to display and choose from. */
	public void setValues(String... values)
	{
		this.setModel(new CList(values).getModel());
	}

}
