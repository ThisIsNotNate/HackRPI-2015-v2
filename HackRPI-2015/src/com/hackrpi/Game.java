package com.hackrpi;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame
{
	public static int mainMenu = 0;
	
	public Game(String name)
	{
		super(name);
		addState(new MainMenu(mainMenu));
	}
	
	public static void main(String[] args)
	{
		
	}
}
