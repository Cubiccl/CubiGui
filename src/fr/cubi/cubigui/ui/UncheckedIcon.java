package fr.cubi.cubigui.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;

import fr.cubi.cubigui.CCheckBox;

/** The icon used for an unchecked {@link CCheckBox}. */
public class UncheckedIcon implements Icon
{
	protected static final int[][] box =
	{
	{ 3, 3, 3, 3 },
	{ 2, 4, 2, 12 },
	{ 3, 13, 3, 13 },
	{ 4, 14, 12, 14 },
	{ 13, 13, 13, 13 },
	{ 4, 2, 12, 2 },
	{ 13, 3, 13, 3 },
	{ 14, 4, 14, 12 } };

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
	}

}
