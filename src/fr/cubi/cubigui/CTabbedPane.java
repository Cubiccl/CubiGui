package fr.cubi.cubigui;

import javax.swing.JTabbedPane;
import javax.swing.plaf.basic.BasicTabbedPaneUI;

/** Custom Tabbed Pane. Not really but this is for consistency. */
public class CTabbedPane extends JTabbedPane
{
	private static final long serialVersionUID = 6984155304644919401L;

	public CTabbedPane()
	{
		this.setUI(new BasicTabbedPaneUI());
	}

}
