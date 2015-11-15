package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class Cutscene extends BasicGameState
{
	Image opener1;
	Image opener2;
	Image opener3;
	
	int sceneIndex;
	int timeLimit;
	int currentTime;
	
	public Cutscene(int id){}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		switch(sceneIndex)
		{
			case 1:
				g.drawImage(opener1, 0, 0);
				break;
			case 2:
				g.drawImage(opener2, 0, 0);
				break;
			case 3:
				g.drawImage(opener3, 0, 0);
				break;
		}
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		if(currentTime >= timeLimit)
		{
			switch(sceneIndex)
			{
				case 1:
					opener1.setAlpha(opener1.getAlpha() - .1F);
					if(opener1.getAlpha() <= 0F)
					{
						currentTime = 0;
						sceneIndex++;
					}
					break;
				case 2:
					opener2.setAlpha(opener2.getAlpha() - .1F);
					if(opener2.getAlpha() <= 0F)
					{
						currentTime = 0;
						sceneIndex++;
					}
					break;
				case 3:
					opener3.setAlpha(opener3.getAlpha() - .1F);
					if(opener1.getAlpha() <= 0F)
					{
						currentTime = 3000;
						sceneIndex++;
					}
					break;
				case 4:
					sbg.getState(Game.END).init(container,sbg);
					sbg.getState(Game.ARENA).init(container ,sbg);
					sbg.enterState(Game.ARENA);
					break;
			}
		}
		else
			currentTime += delta;
	}

	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException
	{
		opener1 = new Image("res/opener1.png");
		opener2 = new Image("res/Opener2.png");
		opener3 = new Image("res/Opener3.png");
		
		sceneIndex = 1;
		timeLimit = 5000;
		currentTime = 0;
	}

	public int getID() 
	{
		return 5;
	}
}
