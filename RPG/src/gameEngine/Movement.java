package gameEngine;

import dataClasses.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;

public class Movement /*implements KeyListener*/{
	public Movement()
	{
		
	}
	
	public int keyTyped(KeyEvent e)
	{
		return e.getKeyCode();
	}

	public int keyReleased(KeyEvent e) 
	{
		return e.getKeyCode();
	}

	public int keyPressed(KeyEvent e) 
	{
		return e.getKeyCode();
	}
}