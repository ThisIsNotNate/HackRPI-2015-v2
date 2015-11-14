package com.hackrpi;

import java.awt.Rectangle;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Entity 
{
	static float posY, posX, speed;
	static int health, healthMax, time, width, height; 
	
	public Entity(){}
	
	public Entity(float x, float y, int h, int hMax, int w, int he) throws SlickException
	{
		posX = x;
		posY = y;
		health = h;
		healthMax = hMax;	
		width = w;
		height = he;
	}
	
	public boolean collides(Entity x)
	{
		Rectangle r1 = new Rectangle((int)posX, (int)posY, this.getWidth(), this.getHeight());
		Rectangle r2 = new Rectangle((int)x.getPosX(), (int)x.getPosY(), x.getWidth(), x.getHeight());
		return r1.intersects(r2);
	}

	public static float getPosY() 
	{
		return posY;
	}

	public static float getPosX() 
	{
		return posX;
	}

	public static int getWidth()
	{
		return width;
	}

	public static int getHeight()
	{
		return height;
	}
	
	public static double getCastTime(int castTime, double factor)
	{
		return (double)castTime + Math.sin(factor * Math.random());
	}
	
}
