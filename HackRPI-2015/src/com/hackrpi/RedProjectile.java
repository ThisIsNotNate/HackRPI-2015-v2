package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class RedProjectile extends Projectile
{
	private Image image;
	private SpriteSheet ss;
	private Animation anim;
	
	public RedProjectile(float x, float y) throws SlickException
	{
		super(30, 1, 25, 25, x, y);
		time = 0;
		image = new Image("res/redProj");
		ss = new SpriteSheet(image, 0, 0);
		anim = new Animation(ss,0);
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		anim.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		posX += delta * speed;
		posY += delta * speed;
			
		anim.update(delta);
	}
}
