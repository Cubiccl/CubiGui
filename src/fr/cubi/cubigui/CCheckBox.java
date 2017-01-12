package fr.cubi.cubigui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;

import fr.cubi.cubigui.ui.CCheckBoxUI;

/** A Custom CheckBox. */
public class CCheckBox extends JCheckBox implements KeyListener
{
	private static final long serialVersionUID = 5104176511435068723L;

	public CCheckBox(String text)
	{
		super(text);
		this.setUI(new CCheckBoxUI());
		this.setBorder(new RoundedCornerBorder());
		this.setBorderPainted(true);
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
			this.setSelected(!this.isSelected());
		}
	}

	@Override
	public void keyTyped(KeyEvent e)
	{}

}
