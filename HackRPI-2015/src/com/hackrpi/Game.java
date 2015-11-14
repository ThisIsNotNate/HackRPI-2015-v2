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
	
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(MAIN_MENU));
		addState(new Arena(ARENA));
		addState(new Pause(PAUSE));
		addState(new Upgrades(UPGRADES));
		addState(new End(END));
	}

	public void initStatesList(GameContainer gc) throws SlickException
	{
		this.getState(MAIN_MENU).init(gc, this);
		this.getState(ARENA).init(gc, this);
		this.getState(PAUSE).init(gc, this);
		this.getState(UPGRADES).init(gc, this);
		this.getState(END).init(gc, this);
	}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game("Bob Ross Siege"), 1280, 720, false);
			appgc.setTargetFrameRate(60);
			appgc.start();
		}
		catch(SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}
