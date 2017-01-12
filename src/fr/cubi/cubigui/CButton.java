package fr.cubi.cubigui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;

import fr.cubi.cubigui.ui.CButtonUI;

/** A Custom Button. */
public class CButton extends JButton implements KeyListener
{
	private static final long serialVersionUID = -4425707045807350000L;

	/** @param text - The text to display. */
	public CButton(String text)
	{
		super(text);
		this.setUI(new CButtonUI());
		this.setBorder(new RoundedCornerBorder());
		this.setFont(DisplayUtils.FONT);
		this.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER) this.getModel().setPressed(true);
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ENTER)
		{
			this.getModel().setPressed(false);
			this.actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{}

}
