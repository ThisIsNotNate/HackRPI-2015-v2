package com.hackrpi;

import java.util.HashMap;
import java.util.Iterator;
import com.hackrpi.Player;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

public class HUD
{
	HashMap<Integer,String> abilities;
	
	Image lockedAbility;
	
	Image knife;
	Image alizarinCrimson;
	Image cadmiumYellow;
	
	public HUD() throws SlickException
	{
		abilities = new HashMap<Integer,String>();
		
		lockedAbility = new Image("res/lockedAbility.png");
		knife = new Image("res/knifeIcon.png");
		alizarinCrimson = new Image("res/alizarinCrimson.png");
		cadmiumYellow = new Image("res/cadmiumYellow.png");
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		int index = 1;
		
		for(String value : abilities.values())
		{
			g.drawImage(lookupImageByString(value), 36 * index, 543);
			index++;
		}
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta, Player player)
	{
		abilities = player.getAbilities();
	}
	
	private Image lookupImageByString(String str)
	{
		if(str == null)
			return lockedAbility;
		switch(str)
		{
			case "KNIFE":
				return knife;
			case "ALIZARIN_CRIMSON":
				return alizarinCrimson;
			case "CADMIUM_YELLOW":
				return cadmiumYellow;
			default:
				return knife;
		}
	}
}