package com.hackrpi;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Entity 
{
	static float posY, posX, speed;
	static int health, healthMax, time; 
	
	public Entity(){}
	
	public Entity(float x, float y, int h, int hMax) throws SlickException
	{
		posX = x;
		posY = y;
		health = h;
		healthMax = hMax;		
	}
}
