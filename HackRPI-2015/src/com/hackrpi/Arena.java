package com.hackrpi;




import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Arena extends BasicGameState
{
	Player player;
	int time;
	static int wave;
	Image background;
	ArrayList<Entity> enemies;
	
	public Arena(int state)
	{
		wave = 1;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		if(wave == 1)
			player = new Player();
		
		time = 0;
		background = new Image("res/grass.jpg");
		enemies = new ArrayList<Entity>();
		switch(wave)
		{
			case 5: enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Cloud());
					enemies.add(new Cloud());
					break;
					
			case 4: enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					break;
				
			case 3: enemies.add(new Tree());
	   				enemies.add(new Cloud());
	   				enemies.add(new Tree());
	   				enemies.add(new Cloud());
	   				enemies.add(new Tree());
	   				enemies.add(new Cloud());
	   				enemies.add(new Tree());
	   				enemies.add(new Cloud());
	   				enemies.add(new Tree());
	   				enemies.add(new Tree());
	   				enemies.add(new Cloud());
	   				enemies.add(new Cloud());
	   				break;
				
			case 2: enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Cloud());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Cloud());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Cloud());
			   		enemies.add(new Cloud());
			   		break;
				
			case 1:	enemies.add(new Tree());
				   	enemies.add(new Tree());
				   	enemies.add(new Tree());
				   	enemies.add(new Tree());
				   	enemies.add(new Tree());
				   	enemies.add(new Cloud());
				   break;
			
			default:
		}
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, -player.getX(), -player.getY());
		g.drawString("Wave: " + wave, 1200, 10);
		HUD.render(container, sbg, g);
		
		player.render(container, sbg, g);
		for(int i = 0; i < enemies.size(); i++)
		{
			if(enemies.get(i) instanceof Tree)
				((Tree)enemies.get(i)).render(container, sbg, g);
			else
				((Cloud)enemies.get(i)).render(container, sbg, g);
		}
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		player.update(container, sbg, delta);
		
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE))
			sbg.enterState(Game.PAUSE);
	}	

	@Override
	public int getID() 
	{
		return 1;
	}
}



