package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ChiselProjectile extends Projectile 
{
	
	public ChiselProjectile(GameContainer container, float x, float y) throws SlickException
	{
		super(50, 5, 30, 45, x, y);
		Input input = container.getInput();
		posX = input.getMouseX();
		posY = input.getMouseY();
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		posX += delta * speed;
		posY += delta * speed;
	}
}
