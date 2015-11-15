package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ChiselProjectile extends Projectile 
{
	private Image image;
	private float rad;
	
	public ChiselProjectile(GameContainer container, float x, float y) throws SlickException
	{
		super(50, 10f, 25, 25, x, y);
		time = 0;
		image = new Image("res/lightningBolt.png");
		Input input = container.getInput();
		rad = (float)(Math.atan2(input.getMouseX() - x, y - input.getMouseY()));
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		image.draw(posX, posY);
	}  
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;

        posX += (float) Math.sin(rad) * speed;
        posY += -(float) Math.cos(rad) * speed;
	}
	
	public int getTime()
	{
		return time;
	}
}
