package com.hackrpi;

public class Weapon
{
	private int damage, range;
	private float speed;
	private Projectile proj;
	
	public static final Weapon KNIFE = new WeaponKnife(50, 20, .8f);
	
	public Weapon(int damage, int range, float speed)
	{
		this.damage = damage;
		this.range = range;
		this.speed = speed;
	}
}
