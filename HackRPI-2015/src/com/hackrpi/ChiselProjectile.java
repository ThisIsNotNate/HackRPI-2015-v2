package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class ChiselProjectile extends Projectile {
	
	private int width, height,range;
	private float speed;
	private Image image;
	private SpriteSheet ss;
	private Animation anim;
	public ChiselProjectile(int d, int s, int w, int l, Image im, float x, float y) throws SlickException {
		super(d, s, w, l, im, x, y);
		width = 90;
		height = 30;
		range = height;
		speed = 1000f;
		image = new Image("res\chiselProj");
		ss = new SpriteSheet(image);
		anim = new Animation(ss,0);
	}
	
}
