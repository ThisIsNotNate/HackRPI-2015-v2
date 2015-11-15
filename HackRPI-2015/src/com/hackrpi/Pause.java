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
	Button exitButton, returnButton;
	Button returnToMainMenuButton;
	
	public Pause(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		exitButton = new Button("res/returnToMainMenuButton.png", 480, 480, 320, 90);
		returnButton = new Button("res/returnButton.png", 480, 300, 320, 90);
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		returnButton.render(g);
		exitButton.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE) || returnButton.isClicked(input))
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
