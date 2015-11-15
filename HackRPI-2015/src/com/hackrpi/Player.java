package com.hackrpi;

import java.util.HashMap;

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
	private static Player player = null;
	
	public static Player getPlayer() throws SlickException
	{
		if(player == null)
			player = new Player();
		
		return player;
	}
	
	public static void resetPlayer()
	{
		player = null;
	}
	
	private HashMap<Integer,String> abilities;
	
	private SpriteSheet sheet;
	private Animation walkingUp, walkingDown, walkingLeft, walkingRight, walking;
	private Animation attackingUp, attackingDown, attackingLeft, attackingRight, attacking;
	private boolean isAttacking;
	private int direction;
	
	private Player() throws SlickException
	{
		abilities = new HashMap<Integer,String>();
		abilities.put(1, "KNIFE");
		abilities.put(2, null);
		abilities.put(3, null);
		abilities.put(4, null);
		
		posX = 595f;
		posY = 315f;
		width = 90;
		height = 90;
		time = 1000;
		healthMax = 100;
		health = healthMax;
		speed = .3f;
		direction = 2;
		sheet = new SpriteSheet("res/BobRoss.png", 90, 90);
		
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
		
		Image[] attackUp = {sheet.getSprite(3,1), sheet.getSprite(4, 1), sheet.getSprite(5, 1)};
		Image[] attackDown = {sheet.getSprite(3,0), sheet.getSprite(4, 0), sheet.getSprite(5, 0)};
		Image[] attackLeft = {sheet.getSprite(3,3), sheet.getSprite(4, 3), sheet.getSprite(5, 3)};
		Image[] attackRight = {sheet.getSprite(3,2), sheet.getSprite(4, 2), sheet.getSprite(5, 2)};
		
		attackingUp = new Animation(attackUp, duration, false);
		changeDuration(attackingUp, 150);
		attackingDown = new Animation(attackDown, duration, false);
		changeDuration(attackingDown, 150);
		attackingLeft = new Animation(attackLeft, duration, false);
		changeDuration(attackingLeft, 150);
		attackingRight = new Animation(attackRight, duration, false);
		changeDuration(attackingRight, 150);
		attacking = new Animation(attackDown, duration, false);
		changeDuration(attacking, 150);
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
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
		{
			switch(direction)
			{
				case 3: walking = attackingUp;
						break;
				case 2:	walking = attackingDown;
						break;
				case 1: walking = attackingLeft;
						break;
				case 0:	walking = attackingRight;
						break;
			}
			isAttacking = true;
			if(time > 100)
			{
				time = 0;
				switch(abilities.get(1))
				{
					case "ALIZARIN_CRIMSON":
						 projectiles.add(new RedProjectile(container, posX + 45, posY + 45));
						 break;
					case "CADMIUM_YELLOW":
						 projectiles.add(new Lightning(2, container, posX + 45, posY + 45));
						 break;
					case "KNIFE":
						 projectiles.add(new ChiselProjectile(container, posX + 45, posY + 45));
						 break;
				}
			}
		}
				
		if(input.isKeyDown(Input.KEY_D) || input.isKeyDown(Input.KEY_RIGHT))
		{
			direction = 0;
			if(!isAttacking)
				walking = walkingRight;
			else
				walking = attackingRight;
			walking.update(delta);
			posX += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_A) || input.isKeyDown(Input.KEY_LEFT))
		{
			direction = 1;
			if(!isAttacking)
				walking = walkingLeft;
			else
				walking = attackingLeft;
			walking.update(delta);
			posX-= delta * speed;
		}
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
		{
			direction = 2;
			if(!isAttacking)
				walking = walkingDown;
			else
				walking = attackingDown;
			walking.update(delta);
			posY += delta * speed;
		}
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
		{
			direction = 3;
			if(!isAttacking)
				walking = walkingUp;
			else
				walking = attackingUp;
			walking.update(delta);
			posY -= delta * speed;
		}
		isAttacking = false;
		
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
	
	public void addAbility(String ability)
	{
		switch(ability)
		{
			case "ALIZARIN_CRIMSON":
				abilities.remove(2);
				abilities.put(2, "ALIZARIN_CRIMSON");
				break;
			case "CADMIUM_YELLOW":
				abilities.remove(2);
				abilities.put(2, "CADMIUM_YELLOW");
				break;
		}
	}
	
	public float getX() { return posX; }	
	
	public float getY() { return posY; }	
	
	public int getHealth() { return health; }
	
	public int getHealthMax() { return healthMax; }
	
	public void setHealth(int h) { health = h; }
	
	public HashMap<Integer,String> getAbilities() { return abilities; }
}