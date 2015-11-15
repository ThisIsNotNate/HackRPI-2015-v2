package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class ChiselProjectile extends Projectile 
{
	
	private Image image;
	private SpriteSheet ss;
	private Animation anim;
	public ChiselProjectile(int d, int s, int w, int l, Image im, float x, float y) throws SlickException
	{
		super(50, 1000, 30, 45, (new Player()).getPosX(), (new Player()).getPosY());
		image = new Image("res/chiselProj");
		ss = new SpriteSheet(image, 0, 0);
		anim = new Animation(ss,0);
	}
	
}
