package fr.cubi.cubigui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

/** A Custom panel. */
public class CPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	/** The GridBagConstraints to use to layout the components. */
	protected GridBagConstraints gbc;

	public CPanel()
	{
		this(null);
	}

	/** Creates a new CPanel.
	 * 
	 * @param title - This panel's title. If null, will not be visible. */
	public CPanel(String title)
	{
		if (title != null) this.setBorder(BorderFactory.createTitledBorder(title));
	}

	/** Creates a GridBagLayout.
	 * 
	 * @return The GridBagConstraints to use to layout the components. */
	public GridBagConstraints createGridBagLayout()
	{
		this.setLayout(new GridBagLayout());
		this.gbc = new GridBagConstraints();
		this.gbc.gridx = 0;
		this.gbc.gridy = 0;
		this.gbc.gridwidth = 1;
		this.gbc.gridheight = 1;
		this.gbc.insets = new Insets(5, 5, 5, 5);
		this.gbc.anchor = GridBagConstraints.NORTH;
		this.gbc.fill = GridBagConstraints.HORIZONTAL;
		return this.gbc;
	}

	/** @return The GridBagConstraints to use to layout the components. */
	public GridBagConstraints getGBC()
	{
		return this.gbc;
	}

}
