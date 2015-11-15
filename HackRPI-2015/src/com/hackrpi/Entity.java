package com.hackrpi;

import java.awt.Rectangle;
import java.util.ArrayList;

import org.newdawn.slick.SlickException;

public class Entity 
{
	float posY, posX;
	float speed;
	int health, healthMax, time, width, height, damage;
	ArrayList<Projectile> projectiles;
	
	public Entity()
	{
		projectiles = new ArrayList<Projectile>();
	}
	
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
		Rectangle r1 = new Rectangle((int)posX, (int)posY, this.width, this.height);
		Rectangle r2 = new Rectangle((int)x.posX, (int)x.posY, x.width, x.height);
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
	
	public int getHealth()
	{
		return health;
	}
	
	public int getDamage()
	{
		return damage;
	}
	
	public ArrayList<Projectile> getProjectiles()
	{
		return projectiles;
	}
	
	public double getCastTime(int castTime, double factor)
	{
		return (double)castTime + Math.sin(factor * Math.random());
	}
	
}
