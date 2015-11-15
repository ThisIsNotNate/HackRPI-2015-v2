package com.hackrpi.gui;

import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;

public class Button
{
	private Image image;
	private int x, y;
	private int width, height;
	private Sound menuSound, confirmSound;
	
	
	public Button(String path, int x, int y, int width, int height) throws SlickException
	{
		image = new Image(path);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		menuSound = new Sound("res/menuButton.ogg");
		confirmSound = new Sound("res/accept.ogg");
	}
	
	public boolean isMouseWithinBounds(Input input)
	{
		if(input.getMouseX() >= x && input.getMouseX() <= x + width
		&& input.getMouseY() >= y && input.getMouseY() <= y + height)
		{
			menuSound.play();
			return true;
		}
		else
			return false;
	}
	
	public boolean isClicked(Input input)
	{
		if(isMouseWithinBounds(input) && input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			confirmSound.play();
			return true;
		}
		else
			return false;
	}
	
	public void render(Graphics g)
	{
		g.drawImage(image, x, y);
	}
}