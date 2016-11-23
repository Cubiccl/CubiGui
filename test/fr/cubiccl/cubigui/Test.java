package fr.cubiccl.cubigui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.cubi.cubigui.CButton;
import fr.cubi.cubigui.CCheckBox;
import fr.cubi.cubigui.CEntry;
import fr.cubi.cubigui.CList;
import fr.cubi.cubigui.CPanel;
import fr.cubi.cubigui.CSpinner;
import fr.cubi.cubigui.CTabbedPane;
import fr.cubi.cubigui.CTable;
import fr.cubi.cubigui.CTextArea;
import fr.cubi.cubigui.CTextField;
import fr.cubi.cubigui.DisplayUtils;
import fr.cubi.cubigui.SearchCombobox;

public class Test extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 4780849921275426385L;

	public static void main(String[] args)
	{
		new Test();
	}

	private CButton button;
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
		this.content.add(new CCheckBox("Checkbox"));
		this.content.add(new CTextField("Textfield"));
		this.content.add((new CEntry("Entry :")).container);
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

		this.setTitle("Kappa");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);

		this.button.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0)
	{
		DisplayUtils.setColor(DisplayUtils.BACKGROUND_COLOR, new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
				this);
	}
}
