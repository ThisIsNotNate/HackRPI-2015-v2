package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Lightning extends Projectile
{
	private Image image;
	private float rad;
	
	public Lightning(int type, GameContainer container, float x, float y) throws SlickException
	{
		super(50, 5f, 25, 25, x, y);
		time = 0;
		image = new Image("res/lightningBolt.png");
		if(type == 1)
		{
			Player p = Player.getPlayer();
			rad = (float)(Math.atan2(p.getX() - x, y - p.getY()));
		}
		else
		{
			Input input = container.getInput();
			rad = (float)(Math.atan2(input.getMouseX() - x, y - input.getMouseY()));
		}
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
}
