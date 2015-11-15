package com.hackrpi;

public class Weapon
{
	private int damage, range, speed;
	private Projectile proj;
	
	public static final Weapon KNIFE = new WeaponKnife(999, 999, 999);
	
	public Weapon(int damage, int range, int speed)
	{
		this.damage = damage;
		this.range = range;
		this.speed = speed;
	}
}
