package fr.cubi.cubigui;

import java.awt.Component;
import java.awt.GridBagConstraints;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/** A Custom Table. Use {@link CTable#container} to add to a container. */
public class CTable extends JTable
{
	private static final long serialVersionUID = -3215772292787478125L;

	/** This table container. */
	public final CPanel container;
	private final String[] columnNames;

	public CTable(String[][] data, String[] columnNames)
	{
		super(data, columnNames);
		this.columnNames = columnNames;

		this.container = new CPanel();
		GridBagConstraints gbc = this.container.createGridBagLayout();
		gbc.insets.top = gbc.insets.bottom = 0;
		this.container.add(this.tableHeader, gbc);
		++gbc.gridy;
		this.container.add(this, gbc);

		this.setAutoResizeMode(AUTO_RESIZE_OFF);
		this.resizeColumnWidth();
	}

	private void resizeColumnWidth()
	{
		final TableColumnModel columnModel = this.getColumnModel();
		for (int column = 0; column < this.getColumnCount(); column++)
		{
			int width = 50; // Min width
			width = Math.max(DisplayUtils.textWidth(this.columnNames[column]), width);
			for (int row = 0; row < this.getRowCount(); row++)
			{
				TableCellRenderer renderer = this.getCellRenderer(row, column);
				Component comp = this.prepareRenderer(renderer, row, column);
				width = Math.max(comp.getPreferredSize().width + 1, width);
			}
			if (width > 300) width = 300; // Max width
			columnModel.getColumn(column).setPreferredWidth(width);
		}
	}
}
