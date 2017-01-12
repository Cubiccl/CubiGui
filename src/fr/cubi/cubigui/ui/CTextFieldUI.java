package fr.cubi.cubigui.ui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.plaf.basic.BasicTextFieldUI;

import fr.cubi.cubigui.CTextField;

public class CTextFieldUI extends BasicTextFieldUI
{

	@Override
	protected void paintSafely(Graphics g)
	{
		super.paintSafely(g);
		CTextField field = (CTextField) this.getComponent();
		if (field.getText().equals(""))
		{
			g.setFont(field.getFont());
			if (field.hasFocus()) g.setColor(Color.GRAY);
			else g.setColor(Color.LIGHT_GRAY);
			g.drawString(field.getSuggestedText(), 8, 5 + g.getFont().getSize());
		}
	}
}
