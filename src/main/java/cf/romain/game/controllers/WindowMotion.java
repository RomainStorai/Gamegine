package cf.romain.game.controllers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WindowMotion extends MouseAdapter {
	
	private Point click;
	private JFrame window;
	
	public WindowMotion(JFrame window, JPanel panel) {	   
		this.window = window;
	}
	
	public void mouseDragged(MouseEvent e) {
		if (this.click != null) {
			Point draggedPoint = MouseInfo.getPointerInfo().getLocation();
			this.window.setLocation(new Point((int)draggedPoint.getX() - (int)this.click.getX(), (int)draggedPoint.getY() - (int)this.click.getY()));
		}
	}
	
	public void mousePressed(MouseEvent e) {
		this.click = e.getPoint();
	}
	
}