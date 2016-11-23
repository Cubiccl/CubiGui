package fr.cubi.cubigui;

import java.awt.GridBagConstraints;

/** A Textfield with a name. Use {@link CEntry#container} to add to a container. */
public class CEntry extends CTextField
{
	private static final long serialVersionUID = 1L;

	/** This entry's container. */
	public final CPanel container;
	/** The label with this entry's name. */
	public final CLabel label;

	/** @param text - The name of the entry. If null, will not be visible. */
	public CEntry(String text)
	{
		this(text, "");
	}

	/** @param text - The name of the entry. If null, will not be visible.
	 * @param defaultValue - The default value, input when created. */
	public CEntry(String text, String defaultValue)
	{
		super();
		this.setText(defaultValue);
		this.label = new CLabel(text);

		this.container = new CPanel();
		GridBagConstraints gbc = this.container.createGridBagLayout();
		this.container.add(this.label, gbc);
		++gbc.gridx;
		this.container.add(this, gbc);
	}

}
