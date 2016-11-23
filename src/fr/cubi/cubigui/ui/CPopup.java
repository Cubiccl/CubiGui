package fr.cubi.cubigui.ui;

import javax.swing.JComboBox;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import fr.cubi.cubigui.RoundedCornerBorder;

public class CPopup extends BasicComboPopup implements ComboPopup
{
	private static final long serialVersionUID = -8225773373432701715L;

	public CPopup(@SuppressWarnings("rawtypes") JComboBox box)
	{
		super(box);
	}

	@Override
	protected void configurePopup()
	{
		super.configurePopup();
		RoundedCornerBorder border = new RoundedCornerBorder(true);
		border.setSmallInsets(true);
		this.setBorder(border);
	}

}
