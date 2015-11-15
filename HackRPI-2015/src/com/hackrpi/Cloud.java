package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Cloud extends Entity
{
	SpriteSheet cloud;
	private Animation cloudAnimation;
	
	public Cloud() throws SlickException
	{
		if(Math.random() < .5)
		{
			posX = (int)(1280 * Math.random());
			if(Math.random() < .5)
				posY = 0;
			else
				posY = 720;
		}
		else
		{
			posY = (int)(720 * Math.random());
			if(Math.random() < .5)
				posX = 0;
			else
				posX = 1280;
		}
		
		time = 0;
		health = 100;
		speed = .08f;
		damage = 20;
		time = 0;
		width = 100;
		height = 100;
		cloud = new SpriteSheet("res/CloudSS_100x100.png", 100, 100);
		cloudAnimation = new Animation(cloud, 100);
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		cloudAnimation.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		if(time > 2000)
		{
			time = 0;
			projectiles.add(new Lightning(posX + 75, posY + 75));
		}
			
		cloudAnimation.update(delta);
	}
}
