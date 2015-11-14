package com.hackrpi;

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
	public Image background;
	public Music menuMusic;
	Sound openingSound, blip;
	double mouseX, mouseY;
	
	public MainMenu(int state)
	{
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		//Initialize bg image.
		Image background = new Image("res/MenuBG.png");
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		Input input = container.getInput();
		
		g.drawImage(new Image("res/MenuBG.png"), 0, 0);
		
		if(mouseX > 290 && mouseX < 990 && mouseY > 430 && mouseY < 530)
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				g.drawImage(new Image("res/PlayButton3.jpg"), 290, 190);
				blip.play(1, .5f);
			}
			else
				g.drawImage(new Image("res/PlayButton2.jpg"), 290, 190);
		}
		
		if(mouseX > 290 && mouseX < 990 && mouseY > 270 && mouseY < 370)
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				g.drawImage(new Image("res/SettingsButton3.jpg"), 290, 350);
				blip.play(1, .5f);
			}
			else
				g.drawImage(new Image("res/SettingsButton2.jpg"), 290, 350);
		}
		
		if(mouseX > 290 && mouseX < 990 && mouseY > 110 && mouseY < 210)
		{
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON))
			{
				g.drawImage(new Image("res/QuitButton3.jpg"), 290, 510);
				blip.play(1, .5f);
				container.exit();
			}
			else
				g.drawImage(new Image("res/QuitButton2.jpg"), 290, 510);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		mouseX = Mouse.getX();
		mouseY = Mouse.getY();
		Input input = container.getInput();
		
		
	}
	
	@Override
	public int getID() 
	{
		return 0;
	}

}
