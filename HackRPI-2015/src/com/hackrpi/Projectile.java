package com.hackrpi;

import org.newdawn.slick.SlickException;

public class Projectile extends Entity
{
	int damage;
	//
	
	public Projectile(int d, float s, int w, int l, float x, float y) throws SlickException
	{
		super(x,y,99999,w,l);
		damage = d;
		speed = s;
	}
	
	public int getDamage(){return damage;}
	
}