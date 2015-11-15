package com.hackrpi;




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
	Image background;
	
	public Arena(int state){}
	
	@Override
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		player = new Player();
		time = 0;
		background = new Image("res/grass.jpg");
	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, -player.getX(), -player.getY());
		
		HUD.render(container, sbg, g);
		g.drawString("Wave 1", 1200, 10);
		
		player.render(container, sbg, g);
		
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



