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
public class Corvaka extends Aggie{

	public Corvaka(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("Ancient Power",attack,"Uses the power of the Ancients to attack the enemy");
		ab[0] = atk;

		Abilities iceShot = new Abilities("Super Duper Defense",debuff,def,"decreses defense of enemy");
		ab[1] = iceShot;
		
		Abilities subZero = new Abilities("Ancient Heal",buff,hp,"Uses the power of the Ancients to Heal");
		ab[2] = subZero;

		ultimate = new Abilities("Attack Mode", condition,trueDMG,"Attack Mode"); 
		ab[3] = ultimate;
		
		return ab;
	}

}