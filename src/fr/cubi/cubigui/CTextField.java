package fr.cubi.cubigui;

import javax.swing.JTextField;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

/** A Custom Textfield. */
public class CTextField extends JTextField
{

	private static final long serialVersionUID = -6329458551850787942L;

	public CTextField()
	{
		this("");
	}

	public CTextField(String defaultValue)
	{
		super(20);
		this.setBorder(new RoundedCornerBorder());
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

	/** Removes all filters from this textfield. */
	public void removeFilter()
	{
		this.addFilter(null);
	}

}
