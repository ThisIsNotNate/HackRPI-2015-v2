package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.StateBasedGame;


public class Player extends Entity
{
	static SpriteSheet player;
	private static Animation playerAnimation;
	
	public Player() throws SlickException
	{
		posY = 50f;
		time = 0;
		healthMax = 100;
		health = healthMax;
		speed = .8f;
		player = new SpriteSheet("res/BobRoss.png", x, y);
		playerAnimation = new Animation(player, 100);

	}

	public static void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		player.draw(posX, posY);
		if(health <= 0)
			sbg.enterState(Game.end);
	}

	public static void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		Input input = container.getInput();
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		{
			
		}
		
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
			posY += delta * speed;
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
			posY -= delta * speed;
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
			posX += delta * speed;
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
			posX-= delta * speed;
		if(posY <= 0)
			posY = 0;
		else if(posY >= 680)
			posY = 680;
		if(posX <= 0)
			posX = 0;
		else if(posX >= 1250)
			posX = 1250;
		playerAnimation.update(delta);
		
	}

	public static float getY() { return posY; }	
	
	public static int getHealth() { return health; }
	
	public static int getHealthMax() { return healthMax; }
	
	public static void setHealth(int h) { health = h; }
	
	public static void setHealthMax(int h)
	{
		healthMax = h;
		health = healthMax;
	}	
}


