package com.hackrpi;

import com.hackrpi.gui.Button;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;

public class Upgrades extends BasicGameState
{
	Image background;
	Button cadmiumYellowUpgrade;
	Button alizarinCrimsonUpgrade;
	
	public Upgrades(int state)
	{
		
	}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		background = new Image("res/upgradeMenu.png");
		
		alizarinCrimsonUpgrade = new Button("res/alizarinCrimsonUpgrade.png", 384, 155, 512, 120);
		cadmiumYellowUpgrade = new Button("res/cadmiumYellowUpgrade.png", 384, 465, 512, 120);
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0, 0);
		alizarinCrimsonUpgrade.render(g);
		cadmiumYellowUpgrade.render(g);
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput(); 
		
		if(alizarinCrimsonUpgrade.isClicked(input))
		{
			Player.getPlayer().addAbility("ALIZARIN_CRIMSON");
		}
		if(cadmiumYellowUpgrade.isClicked(input))
		{
			Player.getPlayer().addAbility("CADMIUM_YELLOW");
		}
	}
	
	@Override
	public int getID() 
	{
		return 3;
	}
}