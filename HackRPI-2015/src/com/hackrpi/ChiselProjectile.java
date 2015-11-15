package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class ChiselProjectile extends Projectile 
{
	private float pX, pY;
	public ChiselProjectile(GameContainer container, float x, float y) throws SlickException
	{
		super(50, .5f, 30, 45, x, y);
		Input input = container.getInput();
		posX = x;
		posY = y;
		pX = x - input.getMouseX();
		pY = y - input.getMouseY();
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		
		if(pX < 0)
			posX += delta * speed;
		else
			posX -= delta * speed;
		if(pY < 0)
			posY += delta * speed;
		else
			posY -= delta * speed;
	}
}
