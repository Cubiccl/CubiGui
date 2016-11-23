package fr.cubi.cubigui.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import fr.cubi.cubigui.CCheckBox;

/** The icon used for a checked {@link CCheckBox}. */
public class CheckedIcon implements Icon
{
	private static final int[][] check =
	{
	{ 5, 6, 7 },
	{ 6, 6, 9 },
	{ 7, 8, 10 },
	{ 8, 9, 11 },
	{ 9, 8, 10 },
	{ 10, 6, 9 },
	{ 11, 5, 7 },
	{ 12, 4, 6 },
	{ 13, 3, 5 },
	{ 14, 2, 4 },
	{ 15, 1, 3 },
	{ 16, 0, 2 } };
	private static final int[][] box =
	{
	{ 3, 3, 3, 3 },
	{ 2, 4, 2, 12 },
	{ 3, 13, 3, 13 },
	{ 4, 14, 12, 14 },
	{ 13, 13, 13, 13 },
	{ 4, 2, 10, 2 },
	{ 14, 7, 14, 12 } };

	@Override
	public int getIconHeight()
	{
		return 16;
	}

	@Override
	public int getIconWidth()
	{
		return 16;
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		g.setColor(new Color(88, 88, 88));
		for (int[] line : box)
			g.drawLine(x + line[0], y + line[1], x + line[2], y + line[3]);

		g.setColor(new Color(15, 188, 78));
		for (int[] line : check)
			g.drawLine(x + line[0], y + line[1], x + line[0], y + line[2]);

	}

}
