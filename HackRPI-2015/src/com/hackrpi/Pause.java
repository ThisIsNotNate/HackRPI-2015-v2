package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.hackrpi.gui.Button;

public class Pause extends BasicGameState
{
	Button exitButton;
	
	public Pause(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		exitButton = new Button("res/returnButton.png", 640 - 160, 360 - 45, 320, 90);
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		exitButton.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE))
			sbg.enterState(Game.ARENA);
		
		if(exitButton.isClicked(input))
			sbg.enterState(Game.MAIN_MENU);
	}
	
	@Override
	public int getID() 
	{
		return 2;
	}
}
