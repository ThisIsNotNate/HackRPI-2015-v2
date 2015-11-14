  package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.state.StateBasedGame;

public class Entity 
{
	static float posY, posX, speed;
	private static int health, healthMax, time; 
	static SpriteSheet ss; 
	
	public static void init(GameContainer gc, StateBasedGame sbg, float x, float y, Image i) throws SlickException
	{
		posX = x;
		posY = y;
		
		
	}
}
