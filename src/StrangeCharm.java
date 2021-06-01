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
public class StrangeCharm extends Aggie{

	public StrangeCharm(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("Constrictor Squeeze",attack,"Damages opponent health through deprivation of oxygen");
		ab[0] = atk;

		Abilities iceShot = new Abilities("Strange Charm",turnLost,"Attack that causes opponent to lose turn");
		ab[1] = iceShot;
		
		Abilities subZero = new Abilities("Cobra Kick",debuff,dmg,"Venomous kick that decreases attack");
		ab[2] = subZero;

		ultimate = new Abilities("Quantum Quark Heal", condition,trueDMG,"Heals self"); 
		ab[3] = ultimate;
		
		return ab;
	}

}