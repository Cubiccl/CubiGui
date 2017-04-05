package fr.cubiccl.cubigui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import fr.cubi.cubigui.*;

public class Test extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 4780849921275426385L;

	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				new Test();
			}
		});
	}

	private CButton button;
	private CCheckBox checkbox;
	private CPanel content;

	public Test()
	{
		this.setContentPane(this.content = new CPanel("Cubi's GUI is OP"));
		CTextArea editable = new CTextArea("This one can \nbe edited!");
		editable.setEditable(true);
		CTabbedPane tabpane = new CTabbedPane();
		tabpane.add("Tabbed", new CPanel("Panel 1"));
		tabpane.add("Pane", new CPanel("Panel 2"));

		this.content.add(this.button = new CButton("Button"));
		this.content.add(this.checkbox = new CCheckBox("Checkbox"));
		this.content.add(new CTextField("Textfield"));
		this.content.add((new CEntry("Entry :", "", "Suggestion...")).container);
		this.content.add((new SearchCombobox("Search", "Combobox")).container);
		this.content.add((new CSpinner("Spinner :", 1, 2, 3)).container);
		this.content.add(new CTextArea("texttexttexttext texttexttexttext \ntexttexttexttexttexttexttexttext texttexttexttexttext"));
		this.content.add(editable);
		this.content.add(new CList("List", "of", "values"));
		this.content.add((new CTable(new String[][]
		{
		{ "Avec", "Plein" },
		{ "de", "données et tout et tout" } }, new String[]
		{ "Une énoooooooooooooorme", "Table" })).container);
		this.content.add(tabpane);
		ButtonGroup group = new ButtonGroup();
		CRadioButton radio = new CRadioButton("Radio");
		group.add(radio);
		this.content.add(radio);
		radio = new CRadioButton("Buttons");
		group.add(radio);
		this.content.add(radio);

		this.setTitle("Kappa");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);

		this.button.addActionListener(this);
		this.checkbox.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				button.setEnabled(checkbox.isSelected());
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		DisplayUtils.setColor(DisplayUtils.BACKGROUND_COLOR, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
				this);
		if (DisplayUtils.showPopup(this, "lol", new JLabel("done!"), "OK", "Cancel")) System.out.println("ok");
	}
}
