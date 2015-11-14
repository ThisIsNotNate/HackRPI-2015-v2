package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
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
		posX = 50f;
		posY = 50f;
		time = 0;
		healthMax = 100;
		health = healthMax;
		speed = .8f;
		player = new SpriteSheet("res/BobRoss.png", 90, 90);
		playerAnimation = new Animation(player, 100);
		
		
		int[] duration = {1, 1, 1, 1};
		
		Image[] walkUp = {sheet.getSprite(0,3), sheet.getSprite(1, 3), sheet.getSprite(2, 3), sheet.getSprite(3, 3)};
		Image[] walkDown = {sheet.getSprite(0,0), sheet.getSprite(1, 0), sheet.getSprite(2, 0), sheet.getSprite(3, 0)};
		Image[] walkLeft = {sheet.getSprite(0,1), sheet.getSprite(1, 1), sheet.getSprite(2, 1), sheet.getSprite(3, 1)};
		Image[] walkRight = {sheet.getSprite(0,2), sheet.getSprite(1, 2), sheet.getSprite(2, 2), sheet.getSprite(3, 2)};
		
		walkingUp = new Animation(walkUp, duration, false);
		changeDuration(walkingUp, 150);
		walkingDown = new Animation(walkDown, duration, false);
		changeDuration(walkingDown, 150);
		walkingLeft = new Animation(walkLeft, duration, false);
		changeDuration(walkingLeft, 150);
		walkingRight = new Animation(walkRight, duration, false);
		changeDuration(walkingRight, 150);
		walking = new Animation(walkUp, duration, false);
		changeDuration(walking, 150);
		
		stepSound = new Sound("res/sound/step1.ogg");
		factor = 0F;
		walkingFlag = false;
		
		Image[] attackUp = {sheet.getSprite(4, 3), sheet.getSprite(5, 3), sheet.getSprite(6, 3), sheet.getSprite(7, 3)};
		Image[] attackDown = {sheet.getSprite(4, 0), sheet.getSprite(5, 0), sheet.getSprite(6, 0), sheet.getSprite(7, 0)};
		Image[] attackLeft = {sheet.getSprite(4, 1), sheet.getSprite(5, 1), sheet.getSprite(6, 1), sheet.getSprite(7, 1)};
		Image[] attackRight = {sheet.getSprite(4, 2), sheet.getSprite(5, 2), sheet.getSprite(6, 2), sheet.getSprite(7, 2)};
		
		attackingUp = new Animation(attackUp, duration, false);
		changeDuration(attackingUp, 75);
		attackingDown = new Animation(attackDown, duration, false);
		changeDuration(attackingDown, 75);
		attackingLeft = new Animation(attackLeft, duration, false);
		changeDuration(attackingLeft, 75);
		attackingRight = new Animation(attackRight, duration, false);
		changeDuration(attackingRight, 75);
		attacking = new Animation(attackUp, duration, false);
		changeDuration(attacking, 75);

	}

	public static void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		playerAnimation.draw(posX, posY);
		if(health <= 0)
			sbg.enterState(Game.END);
	}  

	public static void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		Input input = container.getInput();
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON))
		{
			
		}
		
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
		{
			
			posY += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
		{
			
			posY -= delta * speed;
		}
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
		{
			posX += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
		{
			posX-= delta * speed;
		}
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
	
	public static float getX() { return posX; }	
	
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


