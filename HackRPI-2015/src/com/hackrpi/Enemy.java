package com.hackrpi;

public interface Enemy extends Entity{
	private int castTime;
	
	public static void init(int ct){
		castTime = ct;
	}
	
	public double getCastTime(){
		return (double)castTime + Math.sin(Math.random());
	}
	//test
}
