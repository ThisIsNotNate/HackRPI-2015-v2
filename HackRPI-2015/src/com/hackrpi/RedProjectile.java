package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class RedProjectile extends Projectile
{
	private Image image;
	private SpriteSheet ss;
	private Animation anim;
	public RedProjectile() throws SlickException
	{
		super(30, 300, 25,25,(new Player()).getPosX(), (new Player()).getPosY());
		image = new Image("res/redProj");
		ss = new SpriteSheet(image, 0, 0);
		anim = new Animation(ss,0);
	}
}
