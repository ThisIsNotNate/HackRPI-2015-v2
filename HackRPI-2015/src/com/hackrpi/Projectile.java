package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Projectile extends Entity
{
	private int damage, speed, width, length;
	private Image image;
	private SpriteSheet ss;
	private Animation anim;
	
	public Projectile(int d, int s, int w, int l, Image im, float x, float y) throws SlickException
	{
		super(x,y,99999,99999);
		damage = d;
		speed = s;
		width = w;
		length = l;
		image = im;
		ss = new SpriteSheet(image, 0,0); // Implement the location on subclass;
		anim = new Animation(ss, 0); // implement with subclass
		
	}
	
	public int getDamage(){return damage;}
	
}
