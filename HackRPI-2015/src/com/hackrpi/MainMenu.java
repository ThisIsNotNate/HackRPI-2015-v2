package com.hackrpi;

import com.hackrpi.gui.Button;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class MainMenu extends BasicGameState
{
	Image background;
	Music menuMusic;
	Sound openingSound, blip;
	Button playButton;
	Button exitButton;
	double mouseX, mouseY;
	
	public MainMenu(int state)
	{
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		background = new Image("res/MenuBG.png");
		
		playButton = new Button("res/playButton.png", 1280/4 * 2, 720/8 * 2, 320, 90);
		exitButton = new Button("res/exitButton.png", 1280/4 * 2, 720/8 * 4, 320, 90);
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		Input input = container.getInput();
		
		g.drawImage(background, 0, 0);
		playButton.render(g);
		exitButton.render(g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		
		if(playButton.isClicked(input))
		{
			sbg.enterState(1);
		}
		if(exitButton.isClicked(input))
		{
			container.exit();
		}
	}
	
	@Override
	public int getID() 
	{
		return 0;
	}

}
