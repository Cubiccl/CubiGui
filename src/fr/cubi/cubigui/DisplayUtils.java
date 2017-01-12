package fr.cubi.cubigui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayUtils
{
	/** Colors to use for this GUI. */
	private static Color BACKGROUND = new Color(220, 220, 250), HOVERED = new Color(220, 250, 220), CLICKED = new Color(250, 220, 220), DISABLED = new Color(
			200, 200, 200), BORDER = Color.GRAY, FOCUS = Color.BLUE;

	/** Identifiers for the colors of this GUI. */
	public static final int BACKGROUND_COLOR = 0, HOVERED_COLOR = 1, CLICKED_COLOR = 2, DISABLED_COLOR = 3, BORDER_COLOR = 4, BORDER_COLOR_FOCUS = 5;

	/** Font to use for this GUI. */
	public static final Font FONT = new Font("Dialog", Font.BOLD, 14);

	/** @param colorID - The ID of the color to return. <br />
	 *            See {@link DisplayUtils#BACKGROUND_COLOR} */
	public static Color getColor(int colorID)
	{
		switch (colorID)
		{
			case HOVERED_COLOR:
				return HOVERED;

			case CLICKED_COLOR:
				return CLICKED;

			case DISABLED_COLOR:
				return DISABLED;

			case BORDER_COLOR:
				return BORDER;

			case BORDER_COLOR_FOCUS:
				return FOCUS;

			default:
				return BACKGROUND;
		}
	}

	/** @param colorID - The ID of the color to return. <br />
	 *            See {@link DisplayUtils#BACKGROUND_COLOR}
	 * @param newColor - The new Color to apply.
	 * @param currentComponent - The current most important component. Will be updated so that the colors change. */
	public static void setColor(int colorID, Color newColor, Component currentComponent)
	{
		switch (colorID)
		{
			case BACKGROUND_COLOR:
				BACKGROUND = newColor;
				break;

			case HOVERED_COLOR:
				HOVERED = newColor;
				break;

			case CLICKED_COLOR:
				CLICKED = newColor;
				break;

			case DISABLED_COLOR:
				DISABLED = newColor;
				break;

			case BORDER_COLOR:
				BORDER = newColor;
				break;

			default:
				break;
		}
		currentComponent.repaint();
	}

	/** Displays a message in a popup window.
	 * 
	 * @param frame - The master frame.
	 * @param title - The title of the popup window.
	 * @param message - The message to show. */
	public static void showMessage(JFrame frame, String title, String message)
	{
		showPopup(frame, title, new CTextArea(message));
	}

	/** Displays a component in a popup window.
	 * 
	 * @param frame - The master frame.
	 * @param title - The title of the popup window.
	 * @param component - The component to show. */
	public static void showPopup(JFrame frame, String title, Component content)
	{
		JDialog dialog = new JDialog(frame, title, true);

		JPanel panel = new JPanel(new GridBagLayout());
		CButton button = new CButton("OK");
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				dialog.dispose();
			}
		});

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(content, gbc);
		gbc.gridy++;
		panel.add(Box.createRigidArea(new Dimension(100, 20)), gbc);
		gbc.gridy++;
		panel.add(button, gbc);

		dialog.getContentPane().add(panel);
		dialog.setSize(800, 400);
		dialog.setLocationRelativeTo(frame);
		dialog.setVisible(true);
	}

	/** @param text
	 * @return The width of the input <i>text</i>. */
	public static int textWidth(String text)
	{
		return FONT.getSize() * 4 / 5 * text.length();
	}

}
