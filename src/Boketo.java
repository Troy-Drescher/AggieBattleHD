/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jmedina
 */
import javax.swing.ImageIcon;
public class Boketo extends Aggie{

	public Boketo(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("Rock Throw",attack,"Boketo throws a gaint boulder at the opponent");
		ab[0] = atk;

		Abilities iceShot = new Abilities("Slap",condition,turnLost,"Boketo slaps the opponent across the face");
		ab[1] = iceShot;
		
		Abilities subZero = new Abilities("Taunt",buff,dmg,"Boketo beats his chest and tunts the opponent");
		ab[2] = subZero;

		ultimate = new Abilities("Tree hit", condition,trueDMG,"Boketo picks up a tree and swings it like a baseball bat"); 
		ab[3] = ultimate;
		
		return ab;
	}

}
