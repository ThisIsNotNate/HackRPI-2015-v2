package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Lightning extends Projectile
{
	private Image image;
	private int pX, pY;
	
	public Lightning(float x, float y) throws SlickException
	{
		super(50, .2f, 25, 25, x, y);
		time = 0;
		image = new Image("res/lightningBolt.png");
		Player p = Player.getPlayer();
		pX = (int)x-(int)p.getPosX();
		pY = (int)y-(int)p.getPosY();
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		image.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		if(pX >0)
			posX += delta * speed;
		else
			posX -= delta*speed;
		if(pY > 0)
			posY += delta * speed;
		else
			posY -= delta*speed;
		
	}
}
