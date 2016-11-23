package fr.cubi.cubigui.ui;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;

import fr.cubi.cubigui.DisplayUtils;

/** Renders cells in a Combobox. */
public class CListCellRenderer implements ListCellRenderer<String>
{
	private boolean paintingCombobox = false;

	@Override
	public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus)
	{
		JLabel label = new JLabel(" " + value);
		label.setOpaque(true);
		label.setFont(list.getFont());
		if (this.paintingCombobox) label.setHorizontalAlignment(SwingConstants.CENTER);
		if (!list.isEnabled())
		{
			label.setBackground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR));
			label.setForeground(DisplayUtils.getColor(DisplayUtils.DISABLED_COLOR).darker());
		} else if (isSelected)
		{
			label.setBackground(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR));
			label.setBorder(BorderFactory.createLineBorder(DisplayUtils.getColor(DisplayUtils.HOVERED_COLOR).darker()));
		} else label.setBackground(DisplayUtils.getColor(DisplayUtils.BACKGROUND_COLOR));
		return label;
	}

	public void setPaintingCombobox(boolean painting)
	{
		this.paintingCombobox = painting;
	}

}
