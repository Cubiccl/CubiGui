package fr.cubi.cubigui;

import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JList;
import javax.swing.plaf.basic.BasicListUI;

/** Custom UI for lists. */
public class CListUI extends BasicListUI
{

	@Override
	public Rectangle getCellBounds(@SuppressWarnings("rawtypes") JList list, int index1, int index2)
	{
		Rectangle r = super.getCellBounds(list, index1, index2);
		Insets i = list.getInsets();
		return new Rectangle(r.x - i.left, r.y, r.width + 2 * i.right, r.height);
	}

}
