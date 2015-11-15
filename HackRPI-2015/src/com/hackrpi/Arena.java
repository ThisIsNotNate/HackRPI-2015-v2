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
	int time;
	static int wave;
	Image background;
	HUD hud;
	ArrayList<Entity> enemies;
	ArrayList<Entity> addedEnemies;
	
	public Arena(int state)
	{
		wave = 0;
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		wave++;
		hud = new HUD();
		time = 0;
		background = new Image("res/gameBoard.png");
		enemies = new ArrayList<Entity>();
		addedEnemies = new ArrayList<Entity>();
		if(wave == 1)
			Player.getPlayer();
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

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		if(enemies.size() == 0 && addedEnemies.size() == 0)
			sbg.enterState(Game.UPGRADES);
		g.drawImage(background, -Player.getPlayer().getX(), -Player.getPlayer().getY());
		g.drawString("Wave: " + wave, 1200, 10);
		
		Player.getPlayer().render(container, sbg, g);
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
		
		i = 0;
		while(i < Player.getPlayer().projectiles.size())
		{
			((ChiselProjectile)(Player.getPlayer().projectiles.get(i))).render(container, sbg, g);
			i++;
		}
		
		hud.render(container, sbg, g);
	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		time += delta;
		if((addedEnemies.size() == 0 && enemies.size() > 0) || (enemies.size() > 0 && time > 4500 + 1500 * Math.sin(Math.random())))
		{
			time = 0;
			addedEnemies.add(enemies.get(enemies.size() - 1));
			enemies.remove(enemies.size() - 1);
		}
		Player.getPlayer().update(container, sbg, delta);
		
		Input input = container.getInput();
		if(input.isKeyPressed(Input.KEY_ESCAPE))
			sbg.enterState(Game.PAUSE);
		
		for(int i = 0; i < addedEnemies.size(); i++)
		{			
			if(addedEnemies.get(i) instanceof Tree)
			{
				if(addedEnemies.get(i).posX < Player.getPlayer().posX)
					addedEnemies.get(i).posX += delta * addedEnemies.get(i).speed;
				else
					addedEnemies.get(i).posX -= delta * addedEnemies.get(i).speed;
				
				if(addedEnemies.get(i).posY < Player.getPlayer().posY)
					addedEnemies.get(i).posY += delta * addedEnemies.get(i).speed;
				else
					addedEnemies.get(i).posY -= delta * addedEnemies.get(i).speed;
				((Tree)addedEnemies.get(i)).update(container, sbg, delta);
			}
			else
			{
				if(addedEnemies.get(i).posX < Player.getPlayer().posX - 50)
					addedEnemies.get(i).posX += delta * addedEnemies.get(i).speed;
				else if(addedEnemies.get(i).posX >= Player.getPlayer().posX + 50)
					addedEnemies.get(i).posX -= delta * addedEnemies.get(i).speed;
				
				if(addedEnemies.get(i).posY < Player.getPlayer().posY - 50)
					addedEnemies.get(i).posY += delta * addedEnemies.get(i).speed;
				else if(addedEnemies.get(i).posY >= Player.getPlayer().posY + 50)
					addedEnemies.get(i).posY -= delta * addedEnemies.get(i).speed;
				((Cloud)addedEnemies.get(i)).update(container, sbg, delta);
				
				int j = 0;
				while(j < addedEnemies.get(i).projectiles.size())
				{
					if(addedEnemies.get(i).projectiles.get(j).collides(Player.getPlayer()))
					{
						Player.getPlayer().health = Player.getPlayer().health - addedEnemies.get(i).projectiles.get(j).damage;
						addedEnemies.get(i).projectiles.remove(j);
					}
					else
					{
						((Lightning)addedEnemies.get(i).projectiles.get(j)).update(container, sbg, delta);
						if(addedEnemies.get(i).projectiles.get(j).time > 4500 + 1500*Math.sin(Math.random()))
							addedEnemies.get(i).projectiles.remove(j);
						else
							j++;
					}
				}
			}
			
			if(addedEnemies.get(i).collides(Player.getPlayer()))
			{
				if(addedEnemies.get(i) instanceof Tree && addedEnemies.get(i).collides(Player.getPlayer()) && !((Tree)(addedEnemies.get(i))).isMoving)
					Player.getPlayer().health = Player.getPlayer().health - addedEnemies.get(i).damage;
			}
		}
		int i = 0;
		while(i < Player.getPlayer().projectiles.size())
		{
			boolean removed = false;
			if(Player.getPlayer().projectiles.get(i).time > 100)
			{
				removed = true;
				Player.getPlayer().projectiles.remove(i);
			}
			else
			{
				int j = 0;
				while(j < addedEnemies.size())
				{
					if(Player.getPlayer().projectiles.get(i).collides(addedEnemies.get(j)))
					{
						addedEnemies.get(j).health = addedEnemies.get(j).health - Player.getPlayer().projectiles.get(i).damage;
						if(addedEnemies.get(j).health <= 0)
							addedEnemies.remove(j);
						Player.getPlayer().projectiles.remove(i);
						removed = true;
						break;
					}
					else
					{
						if(Player.getPlayer().projectiles.get(i) instanceof ChiselProjectile)
							((ChiselProjectile)(Player.getPlayer().projectiles.get(i))).update(container, sbg, delta);
						else if(Player.getPlayer().projectiles.get(i) instanceof RedProjectile)
							((RedProjectile)(Player.getPlayer().projectiles.get(i))).update(container, sbg, delta);
						else if(Player.getPlayer().projectiles.get(i) instanceof Lightning)
							((Lightning)(Player.getPlayer().projectiles.get(i))).update(container, sbg, delta);
						j++;
					}
				}
			}
			if(!removed)
				i++;
		}
		hud.update(container, sbg, delta, Player.getPlayer());
	}
	
	public static void resetWave()
	{
		wave = 0;
	}

	@Override
	public int getID() 
	{
		return 1;
	}
}


