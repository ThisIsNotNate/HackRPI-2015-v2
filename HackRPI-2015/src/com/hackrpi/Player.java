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
	public static void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		posY = 50f;
		time = 0;
		type = 1;
		healthMax = 100;
		health = healthMax;
		speed = .8f;
	}

	public static void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{		
		int i = 0;
		while(i < Enemy.getEnemies().size())
		{
			if(getShape().intersects(Enemy.getEnemies().get(i).getShape()))
			{
				health--;
				Enemy.getEnemies().remove(i);
			}
			else
				i++;
		}
		
		if(health <= 0)
			sbg.enterState(Game.end);
	}

	public static void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		Input input = container.getInput();
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) || input.isKeyPressed(Input.KEY_SPACE))
		{
			switch(type)
			{
				case(1): if(time >= 500)
						 {
						 	Laser.getShots().add(new Laser(160, posY + 5));
						 	time = 0;
						 }
						 break;
				case(2): if(time >= 100)
						 {
							Laser.getShots().add(new Burst(160, posY + 5));
							time = 0;
						 }
						 break;
				case(3): if(time >= 1500)
						 {
							Laser.getShots().add(new Beam(160, posY + 5));
							time = 0;
						 }
						 break;
			}
		}
		
		if(input.isKeyDown(Input.KEY_S) || input.isKeyDown(Input.KEY_DOWN))
			posY += delta * speed;
		if(input.isKeyDown(Input.KEY_W) || input.isKeyDown(Input.KEY_UP))
			posY -= delta * speed;
		if(posY <= 0)
			posY = 0;
		else if(posY >= 550)
			posY = 550;
		shipanimation.update(delta);
		
		int i = 0;
		while(i < Weapon.getShots().size())
		{
			switch(type)
			{
				case(1): if(Weapon.getShots().get(i).getX() > 1310)
						     Weapon.getShots().remove(i);
			 	 		 else
			 	 		 {
			 	 			 Weapon.getShots().get(i).setX(Weapon.getShots().get(i).getX() + delta);
			 	 			 i++;
			 	 		 }
						 break;
				case(2): if(Weapon.getShots().get(i).getX() > 1310)
							 Weapon.getShots().remove(i);
					 	 else
					 	 {
					 		 Weapon.getShots().get(i).setX(Weapon.getShots().get(i).getX() + 6 * delta);
					 		 i++;
					 	 }
					 	 break;
				case(3): Weapon.getShots().get(i).setTime(Weapon.getShots().get(i).getTime() + delta);
						 if(Weapon.getShots().get(i).getTime() > 200)
						 {
							 Weapon.getShots().get(i).setTime(0);
							 Weapon.getShots().remove(i);
						 }
						 else
							 i++;
						 break;
				case(4): Weapon.getShots().get(i).setTime(Weapon.getShots().get(i).getTime() + delta);
						 if(Weapon.getShots().get(i).getTime() > 1000)
						 {
							 type = prev;
							 Weapon.getShots().get(i).setTime(0);
							 Weapon.getShots().remove(i);
						 }
						 else
						 {
							 Weapon.getShots().get(i).setY(posY);
							 i++;
						 }
						 break;
			}
		}
	}

	public static float getY()
	{
		return posY;
	}
	
	public static Shape getShape()
	{
		return new Rectangle(50, posY, 134, 62);
	}
	
	public static int getHealth()
	{
		return health;
	}
	
	public static int getHealthMax()
	{
		return healthMax;
	}
	
	public static int getArmor()
	{
		return armor;
	}
	
	public static int getArmorMax()
	{
		return armorMax;
	}
	
	public static double getCooldownRate()
	{
		return cdr;
	}
	
	public static double getMoney()
	{
		return money;
	}
	
	public static double getMoneyMultiplier()
	{
		return moneyMultiplier;
	}
	
	public static void setHealth(int h)
	{
		health = h;
	}
	
	public static void setHealthMax(int h)
	{
		healthMax = h;
		health = healthMax;
	}
	
	public static void setArmor(int a)
	{
		armor = a;
	}

	public static void setArmorMax(int a)
	{
		armorMax = a;
		armor = armorMax;
	}
	
	public static void setCooldownRate(double c)
	{
		cdr = c;
	}
	
	public static void setMoneyMultiplier(double m)
	{
		moneyMultiplier = m;
	}

	public static void setMoney(double m)
	{
		money = m;
	}
}


