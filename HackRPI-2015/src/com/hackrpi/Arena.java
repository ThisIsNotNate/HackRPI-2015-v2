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
	HUD hud;
	ArrayList<Entity> enemies;
	ArrayList<Entity> addedEnemies;
	
	public Arena(int state)
	{
		wave = 1;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		hud = new HUD();
		time = 0;
		background = new Image("res/gameBoard.png");
		enemies = new ArrayList<Entity>();
		addedEnemies = new ArrayList<Entity>();
		if(wave == 1)
			player = new Player();
		switch(wave)
		{
			case 5: enemies.add(new Cloud());
					enemies.add(new Cloud());
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
					enemies.add(new Tree());
					break;
					
			case 4: enemies.add(new Cloud());
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
					enemies.add(new Tree());
					break;
				
			case 3: enemies.add(new Cloud());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
					enemies.add(new Cloud());
					enemies.add(new Tree());
	   				break;
				
			case 2: enemies.add(new Cloud());
	   				enemies.add(new Cloud());
	   				enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Cloud());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Cloud());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		enemies.add(new Tree());
			   		break;
				
			case 1:	enemies.add(new Cloud());
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
		if(enemies.size() == 0 && addedEnemies.size() == 0)
			sbg.enterState(Game.UPGRADES);
		g.drawImage(background, - player.getX(), -player.getY());
		g.drawString("Wave: " + wave, 1200, 10);
		
		player.render(container, sbg, g);
		int i = 0; 
		while(i < addedEnemies.size())
		{
			if(addedEnemies.get(i).getHealth() <= 0)
				addedEnemies.remove(i);
			else
			{
				if(addedEnemies.get(i) instanceof Tree)
					((Tree)addedEnemies.get(i)).render(container, sbg, g);
				else
				{
					int j = 0;
					while(j < addedEnemies.get(i).projectiles.size())
					{
						if(addedEnemies.get(i).projectiles.get(j).time > 1000)
							addedEnemies.get(i).projectiles.remove(j);
						else
						{
							((Lightning)addedEnemies.get(i).projectiles.get(j)).render(container, sbg, g);
							j++;
						}
					}
					((Cloud)addedEnemies.get(i)).render(container, sbg, g);
				}
				i++;
			}
		}
		hud.render(container, sbg, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		if((addedEnemies.size() == 0 && enemies.size() > 0) || (enemies.size() > 0 && time > 1000))
		{
			time = 0;
			addedEnemies.add(enemies.get(enemies.size() - 1));
			enemies.remove(enemies.size() - 1);
		}
		player.update(container, sbg, delta);
		
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE))
			sbg.enterState(Game.PAUSE);
		
		for(int i = 0; i < addedEnemies.size(); i++)
		{			
			if(addedEnemies.get(i) instanceof Tree)
			{
				if(addedEnemies.get(i).posX < player.posX)
					addedEnemies.get(i).posX += delta * addedEnemies.get(i).speed;
				else
					addedEnemies.get(i).posX -= delta * addedEnemies.get(i).speed;
				
				if(addedEnemies.get(i).posY < player.posY)
					addedEnemies.get(i).posY += delta * addedEnemies.get(i).speed;
				else
					addedEnemies.get(i).posY -= delta * addedEnemies.get(i).speed;
				((Tree)addedEnemies.get(i)).update(container, sbg, delta);
			}
			else
			{
				if(addedEnemies.get(i).posX < player.posX - 50)
					addedEnemies.get(i).posX += delta * addedEnemies.get(i).speed;
				else if(addedEnemies.get(i).posX >= player.posX + 50)
					addedEnemies.get(i).posX -= delta * addedEnemies.get(i).speed;
				
				if(addedEnemies.get(i).posY < player.posY - 50)
					addedEnemies.get(i).posY += delta * addedEnemies.get(i).speed;
				else if(addedEnemies.get(i).posY >= player.posY + 50)
					addedEnemies.get(i).posY -= delta * addedEnemies.get(i).speed;
				((Cloud)addedEnemies.get(i)).update(container, sbg, delta);
				
				int j = 0;
				while(j < addedEnemies.get(i).projectiles.size())
				{
					if(addedEnemies.get(i).projectiles.get(j).collides(player))
					{
						player.health = player.health - addedEnemies.get(i).projectiles.get(j).damage;
						addedEnemies.get(i).projectiles.remove(j);
					}
					else
					{
						((Lightning)addedEnemies.get(i).projectiles.get(j)).update(container, sbg, delta);
						if(addedEnemies.get(i).projectiles.get(j).time > 1000)
							addedEnemies.get(i).projectiles.remove(j);
						else
							j++;
					}
				}
			}
			
			if(addedEnemies.get(i).collides(player))
				player.health = player.health - addedEnemies.get(i).damage;
		}
		//hud.update(container, sbg, delta, player);
	}	

	@Override
	public int getID() 
	{
		return 1;
	}
}



