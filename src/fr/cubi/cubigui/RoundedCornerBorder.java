package fr.cubi.cubigui;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.AbstractBorder;

/** A Border with round corners. */
public class RoundedCornerBorder extends AbstractBorder
{
	private static final long serialVersionUID = 1L;

	private boolean smallRadius;
	private boolean smallInsets;

	public RoundedCornerBorder()
	{
		this(false);
	}

	public RoundedCornerBorder(boolean smallRadius)
	{
		this.smallRadius = smallRadius;
	}

	public void setSmallInsets(boolean smallInsets)
	{
		this.smallInsets = smallInsets;
	}

	@Override
	public Insets getBorderInsets(Component c)
	{
		if (this.smallInsets) return new Insets(1, 1, 1, 1);
		return new Insets(4, 8, 4, 8);
	}

	@Override
	public Insets getBorderInsets(Component c, Insets insets)
	{
		if (this.smallInsets) insets.left = insets.right = insets.top = insets.bottom = 1;
		else
		{
			insets.left = insets.right = 8;
			insets.top = insets.bottom = 4;
		}
		return insets;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int r = height - 1;
		if (this.smallRadius) r = 5;
		RoundRectangle2D round = new RoundRectangle2D.Float(x, y, width - 1, height - 1, r, r);
		Container parent = c.getParent();
		if (parent != null)
		{
			g2.setColor(parent.getBackground());
			Area corner = new Area(new Rectangle2D.Float(x, y, width, height));
			corner.subtract(new Area(round));
			g2.fill(corner);
		}
		g2.setColor(DisplayUtils.getColor(DisplayUtils.BORDER_COLOR));
		g2.draw(round);
		g2.dispose();
	}
}
