package com.hackrpi;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;

public class Enemy implements Entity
{
	private static int castTime;
	
	public static void init(int ct, GameContainer gc, StateBasedGame sbg, float x, float y, int h, int hMax)
	{
		Enemy enemy = new Entity(gc,sbg,x,y,h,hMax);
		castTime = ct;
		
		
	}
	
	public static double getCastTime(double factor){
		return (double)castTime + Math.sin(factor * Math.random());
	}
	//test2
}
