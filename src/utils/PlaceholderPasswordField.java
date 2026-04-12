package utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPasswordField;

public class PlaceholderPasswordField extends JPasswordField {
	
	private String placeholder;

    public PlaceholderPasswordField(String placeholder) {
        this.placeholder = placeholder;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getPassword().length == 0) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(new Color(180, 180, 180));
            g2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            g2.drawString(placeholder, 8, getHeight() / 2 + 5);
            g2.dispose();
        }
    }

}