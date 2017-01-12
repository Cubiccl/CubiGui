package fr.cubi.cubigui;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

import fr.cubi.cubigui.ui.CTextFieldUI;

/** A Custom Textfield. */
public class CTextField extends JTextField implements FocusListener
{

	private static final long serialVersionUID = -6329458551850787942L;

	/** This textfield's suggested text. Will show in light gray italics when this textfield this empty. */
	private String suggestedText;

	public CTextField()
	{
		this("");
	}

	public CTextField(String defaultValue)
	{
		this(defaultValue, "");
	}

	public CTextField(String defaultValue, String suggestedText)
	{
		super(20);
		this.suggestedText = suggestedText;
		this.setText(defaultValue);
		this.setBorder(new RoundedCornerBorder());
		this.addFocusListener(this);
		this.setUI(new CTextFieldUI());
	}

	/** Adds a filter to this textfield.
	 * 
	 * @param filter - The filter to add. */
	public void addFilter(DocumentFilter filter)
	{
		((PlainDocument) this.getDocument()).setDocumentFilter(filter);
	}

	/** Adds an integer filter. Only integers can be input. */
	public void addIntFilter()
	{
		this.addFilter(new AbstractFilter()
		{

			@Override
			protected boolean isStringValid(String string)
			{
				try
				{
					Integer.parseInt(string);
					return true;
				} catch (Exception e)
				{
					return false;
				}
			}
		});
	}

	/** Adds a number filter. Only numbers can be input. */
	public void addNumberFilter()
	{
		this.addFilter(new AbstractFilter()
		{

			@Override
			protected boolean isStringValid(String string)
			{
				try
				{
					Float.parseFloat(string);
					return true;
				} catch (Exception e)
				{
					return false;
				}
			}
		});
	}

	@Override
	public void focusGained(FocusEvent e)
	{
		this.repaint();
	}

	@Override
	public void focusLost(FocusEvent e)
	{
		this.repaint();
	}

	/** @return The suggested text. {@link CTextField#suggestedText} */
	public String getSuggestedText()
	{
		return this.suggestedText;
	}

	/** Removes all filters from this textfield. */
	public void removeFilter()
	{
		this.addFilter(null);
	}

	/** Changes the suggested text.
	 * 
	 * @param suggestedText - The new suggested text to apply. {@link CTextField#suggestedText} */
	public void setSuggestedText(String suggestedText)
	{
		this.suggestedText = suggestedText;
	}

}
