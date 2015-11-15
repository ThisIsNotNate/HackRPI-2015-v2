package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Tree extends Entity
{
	SpriteSheet tree;
	private Animation treeMoving, treeAttacking, moving;
	boolean isMoving;
	
	public Tree() throws SlickException
	{
		if(Math.random() < .5)
		{
			posX = (int)(1280 * Math.random());
			if(Math.random() < .5)
				posY = 0;
			else
				posY = 720;
		}
		else
		{
			posY = (int)(720 * Math.random());
			if(Math.random() < .5)
				posX = 0;
			else
				posX = 1280;
		}
		isMoving = true;
		time = 0;
		health = 100;
		speed = .08f;
		damage = 10;
		width = 90;
		height = 90;
		tree = new SpriteSheet("res/treeSprite.png", 90, 90);
		int[] duration = {1};
		Image[] move = {tree.getSprite(0,0)};
		Image[] attack = {tree.getSprite(1,0)};
		
		treeMoving = new Animation(move, duration, false);
		changeDuration(treeMoving, 150);
		treeAttacking = new Animation(attack, duration, false);
		changeDuration(treeAttacking, 150);
		
		moving = new Animation(move, duration, false);
		changeDuration(moving, 150);
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		moving.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		if(time > 100 && !isMoving)
		{
			isMoving = true;
			time = 0;
			moving = treeMoving;
			moving.update(delta);
		}
		else if(time > 1000)
		{
			time = 0;
			isMoving = false;
			moving = treeAttacking;
			moving.update(delta);
		}
			
			
	}
	
	private void changeDuration(Animation an, int dur)	
	{		
		int c = an.getFrameCount();
		for(int i = 0; i < c; i++)
			an.setDuration(i, dur);
	}	
}
