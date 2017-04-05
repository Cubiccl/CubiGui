package fr.cubi.cubigui;

import java.awt.GridBagConstraints;
import java.awt.event.*;

/** A Custom spinner. Use {@link CEntry#container} to add in a container. */
public class CSpinner extends CEntry implements ActionListener
{
	private static final long serialVersionUID = -2618376540277157790L;

	private CButton buttonPlus, buttonMinus;
	private int index;
	private int[] values;

	/** Creates a new CSpinner.
	 * 
	 * @param text - The name of the spinner. If null, won't be visible.
	 * @param values - The values the user can choose. */
	public CSpinner(String text, int... values)
	{
		super(text);
		if (text == null) this.label.setVisible(false);
		this.index = 0;
		this.values = values;

		GridBagConstraints gbc = this.container.gbc;
		++gbc.gridx;
		this.container.add(this.buttonMinus = new CButton(null), gbc);
		++gbc.gridx;
		this.container.add(this.buttonPlus = new CButton(null), gbc);

		this.buttonMinus.setText(" -  ");
		this.buttonPlus.setText(" + ");
		this.buttonMinus.addActionListener(this);
		this.buttonPlus.addActionListener(this);
		this.updateDisplay();
		this.addIntFilter();
		this.addKeyListener(new KeyListener()
		{

			@Override
			public void keyPressed(KeyEvent arg0)
			{}

			@Override
			public void keyReleased(KeyEvent e)
			{
				if (e.getKeyCode() == KeyEvent.VK_ENTER) verifyInput();
				else if (e.getKeyCode() == KeyEvent.VK_UP) increment();
				else if (e.getKeyCode() == KeyEvent.VK_DOWN) decrement();
			}

			@Override
			public void keyTyped(KeyEvent arg0)
			{}
		});
		this.addFocusListener(new FocusListener()
		{

			@Override
			public void focusGained(FocusEvent e)
			{}

			@Override
			public void focusLost(FocusEvent e)
			{
				verifyInput();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == this.buttonPlus)
		{
			this.verifyInput();
			this.increment();
		} else if (e.getSource() == this.buttonMinus)
		{
			this.verifyInput();
			this.decrement();
		}
		for (ActionListener listener : this.getActionListeners())
			listener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ""));
	}

	/** Decrements this Spinner's current value. */
	public void decrement()
	{
		if (this.index > 0) --this.index;
		this.updateDisplay();
	}

	/** @return The value selected by the user. */
	public int getValue()
	{
		if (this.values == null) return 0;
		if (this.values.length == 0) return 0;
		return this.values[this.index];
	}

	/** Increments this Spinner's current value. */
	public void increment()
	{
		if (this.index < this.values.length - 1) ++this.index;
		this.updateDisplay();
	}

	@Override
	public void setText(String t)
	{
		super.setText(t);
		this.verifyInput();
	}

	/** Changes the values.
	 * 
	 * @param values - The values the user can choose. */
	public void setValues(int... values)
	{
		this.values = values;
		if (this.index >= this.values.length) this.index = this.values.length - 1;
		this.updateDisplay();
	}

	private void updateDisplay()
	{
		super.setText(Integer.toString(this.getValue()));
	}

	private void verifyInput()
	{
		try
		{
			int input = Integer.parseInt(this.getText());

			for (int i = 0; i < this.values.length; ++i)
				if (this.values[i] == input)
				{
					this.index = i;
					this.updateDisplay();
					return;
				}

			int below = 0, belowD = input - this.values[0], above = this.values.length - 1, aboveD = this.values[this.values.length - 1] - input;
			for (int i = 0; i < this.values.length; ++i)
			{
				int value = this.values[i];
				if (value < input)
				{
					below = i;
					belowD = input - value;
				}
				if (value > input)
				{
					above = i;
					aboveD = value - input;
					break;
				}
			}
			if (aboveD > belowD) this.index = below;
			else this.index = above;
		} catch (Exception e)
		{}
		this.updateDisplay();
	}

}
