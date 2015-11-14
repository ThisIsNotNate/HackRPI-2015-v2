package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Tree extends Entity
{
	SpriteSheet tree;
	private Animation treeAnimation;
	
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
		time = 0;
		healthMax = 100;
		health = healthMax;
		speed = .8f;
		tree = new SpriteSheet("res/Tree.png", 90, 90);
		treeAnimation = new Animation(tree, 100);
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		treeAnimation.draw(posX, posY);
	}  

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		if(posX < Player.getX())
			posX += delta * speed;
		else
			posX -= delta * speed;
		if(posY < Player.getY())
			posY += delta * speed;
		else
			posY -= delta * speed;
		treeAnimation.update(delta);
		
	}
}
