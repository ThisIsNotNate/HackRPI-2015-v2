package com.hackrpi.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.lwjgl.input.Mouse;

public class Button
{
	private Image image;
	private int x, y;
	private int width, height;
	
	
	public Button(String path, int x, int y, int width, int height) throws SlickException
	{
		image = new Image(path);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void method()
	{}
	
	public boolean isMouseWithinBounds(Input input)
	{
		if(input.getMouseX() >= x && input.getMouseX() <= x + width
		&& input.getMouseY() >= y && input.getMouseY() <= y + height)
			return true;
		else
			return false;
	}
	
	public boolean isClicked(Input input)
	{
		if(isMouseWithinBounds(input) && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			return true;
		else
			return false;
	}
}
