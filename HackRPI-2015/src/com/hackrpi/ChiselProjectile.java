package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ChiselProjectile extends Projectile 
{
	
	private Image image;
	
	public ChiselProjectile(int d, int s, int w, int l, Image im, float x, float y) throws SlickException
	{
		super(50, 5, 30, 45, x, y);
		image = new Image("res/chiselProj");
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
