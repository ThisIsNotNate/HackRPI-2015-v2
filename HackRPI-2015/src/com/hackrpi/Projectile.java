package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Projectile extends Entity throws SlickException
{
	private int damage, speed, width, length;
	
	public Projectile(int d, int s, int w, int l, float x, float y) 
	{
		super(x,y,99999,99999,w,l);
		damage = d;
		speed = s;
	}
	
	public int getDamage(){return damage;}
	
}
