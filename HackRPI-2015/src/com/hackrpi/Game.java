package com.hackrpi;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
	public static final int mainMenu = 0;
	public static final int arena = 1;
	public static final int pause = 2;
	public static final int upgrades = 3;
	public static final int end = 4;
	
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(mainMenu));
		addState(new Arena(arena));
		addState(new Pause(pause));
		addState(new Upgrades(upgrades));
		addState(new End(end));
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {}
	
	public static void main(String[] args)
	{
		AppGameContainer appgc;
		try
		{
			appgc = new AppGameContainer(new Game("Bob Ross Siege"), 1280, 720, false);
			appgc.start();
		}
		catch(SlickException ex)
		{
			ex.printStackTrace();
		}
	}
}
