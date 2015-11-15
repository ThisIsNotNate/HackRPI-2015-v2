package com.hackrpi;

import java.awt.Rectangle;
import org.newdawn.slick.SlickException;

public class Entity 
{
	float posY, posX, speed;
	int health, healthMax, time, width, height; 
	
	public Entity(){}
	
	public Entity(float x, float y, int hMax, int w, int he) throws SlickException
	{
		posX = x;
		posY = y;
		healthMax = hMax;
		health = healthMax;
		width = w;
		height = he;
	}
	
	public boolean collides(Entity x)
	{
		Rectangle r1 = new Rectangle((int)posX, (int)posY, this.getWidth(), this.getHeight());
		Rectangle r2 = new Rectangle((int)x.getPosX(), (int)x.getPosY(), x.getWidth(), x.getHeight());
		return r1.intersects(r2);
	}

	public float getPosY() 
	{
		return posY;
	}

	public float getPosX() 
	{
		return posX;
	}

	public int getWidth()
	{
		return width;
	}

	public int getHeight()
	{
		return height;
	}
	
	public double getCastTime(int castTime, double factor)
	{
		return (double)castTime + Math.sin(factor * Math.random());
	}
	
}
