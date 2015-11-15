package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.hackrpi.gui.Button;

public class End extends BasicGameState
{
	Image death;
	Button exitButton;
	Sound spooky;
	private boolean played = false;
	public End(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException
	{
		death = new Image("res/DeathScreen.png");

		exitButton = new Button("res/returnToMainMenuButton.png", 480, 480, 320, 90);
		played = false;
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		death.draw(0,0);
		exitButton.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		
		if(!played)
		{
			spooky = new Sound("res/BeatTheDevil.wav");
			spooky.play();
			played = true;
		}
		Input input = container.getInput();
		if(exitButton.isClicked(input))
			sbg.enterState(Game.MAIN_MENU);
			
	}
	
	@Override
	public int getID() 
	{
		return 4;
	}
	
	public void reset()
	{
		played = false;
	}
}
