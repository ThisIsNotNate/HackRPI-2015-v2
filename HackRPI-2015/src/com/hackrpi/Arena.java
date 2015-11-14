package com.hackrpi;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Arena extends BasicGameState
{
	static int time;
	
	public Arena(int state){}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		Player player = new Player();
		time = 0;
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		HUD.render(container, sbg, g);
		g.drawString("Level 1", 1200, 10);
		
		Player.render(container, sbg, g);
		Enemy.render(container, sbg, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		Player.update(container, sbg, delta);
		Enemy.update(container, sbg, delta);
		
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_ESCAPE))
			sbg.enterState(Game.pause);
	}	

	@Override
	public int getID() 
	{
		return 1;
	}
}



