package com.hackrpi;

import com.hackrpi.gui.Button;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Music;

public class MainMenu extends BasicGameState
{
	Image background, rossSig;
	Image opener1, opener2, opener3;
	Music menuMusic;
	Sound openingSound, blip;
	Button playButton;
	Button exitButton;
	boolean flag;
	
	public MainMenu(int state){}
	
	public void init(GameContainer container, StateBasedGame sbg) throws SlickException 
	{
		background = new Image("res/MenuBG.png");
		rossSig = new Image("res/rossSig.png");
		
		opener1 = new Image("res/opener1.png");
		opener2 = new Image("res/Opener2.png");
		opener3 = new Image("res/Opener3.png");
		flag = false;
		
		openingSound = new Sound("res/HappyLittleTreesFinal.wav");
		openingSound.play();
		
		playButton = new Button("res/playButton.png", 480, 300, 320, 90);
		exitButton = new Button("res/exitButton.png", 480, 480, 320, 90);
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g) throws SlickException
	{
		g.drawImage(background, 0, 0);
		g.drawImage(rossSig, 390, 0);
		playButton.render(g);
		exitButton.render(g);
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) throws SlickException 
	{
		Input input = container.getInput();
		
		if(playButton.isClicked(input))
		{
			Player.resetPlayer();
			Arena.resetWave();
			openingSound.stop();
//			sbg.enterState(Game.CUTSCENE);
			sbg.enterState(Game.ARENA);
		}
		
		if(exitButton.isClicked(input))
		{
			container.exit();
			openingSound.stop();
		}
	}
	
	public int getID() 
	{
		return 0;
	}

}
