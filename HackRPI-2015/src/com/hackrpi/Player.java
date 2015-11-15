package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;


public class Player extends Entity
{
	SpriteSheet sheet;
	private Animation walkingUp, walkingDown, walkingLeft, walkingRight, walking;
	boolean isWalking;
	
	public Player() throws SlickException
	{
		posX = 595f;
		posY = 315f;
		width = 90;
		height = 90;
		time = 0;
		healthMax = 100;
		health = healthMax;
		speed = .3f;
		sheet = new SpriteSheet("res/BobRoss.png", 90, 90);
		isWalking = false;
		
		int[] duration = {1, 1, 1};
		
		Image[] walkUp = {sheet.getSprite(0,1), sheet.getSprite(1, 1), sheet.getSprite(2, 1)};
		Image[] walkDown = {sheet.getSprite(0,0), sheet.getSprite(1, 0), sheet.getSprite(2, 0)};
		Image[] walkLeft = {sheet.getSprite(0,3), sheet.getSprite(1, 3), sheet.getSprite(2, 3)};
		Image[] walkRight = {sheet.getSprite(0,2), sheet.getSprite(1, 2), sheet.getSprite(2, 2)};
		
		walkingUp = new Animation(walkUp, duration, false);
		changeDuration(walkingUp, 150);
		walkingDown = new Animation(walkDown, duration, false);
		changeDuration(walkingDown, 150);
		walkingLeft = new Animation(walkLeft, duration, false);
		changeDuration(walkingLeft, 150);
		walkingRight = new Animation(walkRight, duration, false);
		changeDuration(walkingRight, 150);
		walking = new Animation(walkDown, duration, false);
		changeDuration(walking, 150);
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		walking.draw(posX, posY);
		if(health <= 0)
			sbg.enterState(Game.END);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		Input input = container.getInput();
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		{
			
		}
				
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
		{
			walking = walkingRight;
			walking.update(delta);
			posX += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
		{
			walking = walkingLeft;
			walking.update(delta);
			posX-= delta * speed;
		}
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
		{
			walking = walkingDown;
			walking.update(delta);
			posY += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
		{
			walking = walkingUp;
			walking.update(delta);
			posY -= delta * speed;
		}
		
		if(posY <= 0)
			posY = 0;
		else if(posY >= 680)
			posY = 680;
		if(posX <= 0)
			posX = 0;
		else if(posX >= 1250)
			posX = 1250;
	}
	
	private void changeDuration(Animation an, int dur)	
	{		
		int c = an.getFrameCount();
		for(int i = 0; i < c; i++)
			an.setDuration(i, dur);
	}	
	
	public float getX() { return posX; }	
	
	public float getY() { return posY; }	
	
	public int getHealth() { return health; }
	
	public int getHealthMax() { return healthMax; }
	
	public void setHealth(int h) { health = h; }
}


