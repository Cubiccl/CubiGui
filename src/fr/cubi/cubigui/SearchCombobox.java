package fr.cubi.cubigui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

/** A Combobox with a searchbar. Use {@link SearchCombobox#container} to add to a container. */
public class SearchCombobox extends CComboBox implements KeyListener
{

	private static final long serialVersionUID = 5018870150343109671L;

	/** The container of this Combobox. */
	public final CPanel container;
	/** This Combobox's search bar. Any text typed in this bar will be compared to this box's values, and only the ones matching will be displayed. Ignores case. */
	public final CTextField searchbar;
	/** This Combobox's values. Not to be mistaken with {@link CComboBox#values} which are the visible values. */
	private String[] values;

	/** Creates a new SearchCombobox.
	 * 
	 * @param values - The values the user can choose. */
	public SearchCombobox(String... values)
	{
		super(values);
		this.values = values;
		this.searchbar = new CTextField();
		this.searchbar.addKeyListener(this);

		this.container = new CPanel();
		this.container.setLayout(new GridLayout(2, 1));
		this.container.add(this.searchbar);
		this.container.add(this);
		this.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				onSelection();
			}
		});
	}

	private void displayValues(String[] values)
	{
		super.setValues(values);
	}

	@Override
	public void keyPressed(KeyEvent arg0)
	{}

	@Override
	public void keyReleased(KeyEvent arg0)
	{
		this.search(arg0.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent arg0)
	{}

	private void onSelection()
	{
		String selected = (String) this.getSelectedItem();
		this.displayValues(this.values);
		if (selected != null) this.setSelectedItem(selected);
		this.searchbar.setText("");
	}

	private void search(int keyCode)
	{
		if (this.searchbar.getText().equals("")) this.displayValues(this.values);
		else if (keyCode == KeyEvent.VK_ENTER) this.onSelection();
		else
		{
			ArrayList<String> matching = new ArrayList<String>();
			for (String value : this.values)
				if (value.toLowerCase().contains(this.searchbar.getText().toLowerCase())) matching.add(value);
			this.displayValues(matching.toArray(new String[matching.size()]));
		}
	}

	@Override
	public void setValues(String[] values)
	{
		this.displayValues(values);
		this.values = values;
		this.searchbar.setText("");
	}

}
