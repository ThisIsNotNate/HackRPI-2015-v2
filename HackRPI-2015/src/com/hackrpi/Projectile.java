package com.hackrpi;

import org.newdawn.slick.SlickException;

public class Projectile extends Entity
{
	private int damage, speed, width, length;
	
	public Projectile(int d, int s, int w, int l, float x, float y) throws SlickException
	{
		super(x,y,99999,w,l);
		damage = d;
		speed = s;
	}
	
	public int getDamage(){return damage;}
	
}
