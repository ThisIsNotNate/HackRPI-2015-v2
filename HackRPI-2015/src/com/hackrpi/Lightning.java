package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Lightning extends Projectile
{
	private Image image;
	
	public Lightning(float x, float y) throws SlickException
	{
		super(30, .2f, 25, 25, x, y);
		time = 0;
		image = new Image("res/lightningBolt.png");
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		image.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		posX += delta * speed;
		posY += delta * speed;
	}
}
