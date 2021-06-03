/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author troyd
 */
import javax.swing.ImageIcon;
public class CalcPuff extends Aggie{

	public CalcPuff(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("Double Derive",attack,"Double ray attack");
		ab[0] = atk;

		Abilities iceShot = new Abilities("Test Rework",buff,hp,"Heals");
		ab[1] = iceShot;
		
		Abilities subZero = new Abilities("Inverse Trig",condition,turnLost,"Flips enemy upside down and causes confusion");
		ab[2] = subZero;

		ultimate = new Abilities("AP EXAM!!!!!", condition,trueDMG,"Devastating multiattack that comes from all sides"); 
		ab[3] = ultimate;
		
		return ab;
	}

}
