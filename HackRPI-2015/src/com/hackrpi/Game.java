package com.hackrpi;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
	public static final int MAIN_MENU = 0;
	public static final int ARENA = 1;
	public static final int PAUSE = 2;
	public static final int UPGRADES = 3;	
	public static final int END = 4;
	public static final int CUTSCENE = 5;
	
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(MAIN_MENU));
		addState(new Arena(ARENA));
		addState(new Pause(PAUSE));
		addState(new Upgrades(UPGRADES));
		addState(new End(END));
		addState(new Cutscene(CUTSCENE));
	}

	public void initStatesList(GameContainer gc) throws SlickException {}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game("Bob Ross Siege"), 1280, 720, false);
			appgc.setIcon("res/icon.jpg");
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch(SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}
