package com.hackrpi;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
	public static int mainMenu = 0;
	public static int arena = 1;
	
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(mainMenu));
		addState(new Arena(arena));
	}
	
	public static void main(String[] args)
	{
		
	}
}
