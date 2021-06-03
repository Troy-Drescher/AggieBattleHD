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
public class Ghoully extends Aggie{

	public Ghoully(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	   public Abilities [] getAbilities() {

           // for attacks
	Abilities [] ab = new Abilities[4];
	Abilities atk = new Abilities("Dark Pulse",attack,"Sends out a dark pulse across the air that does blunt physical damage.");
	ab[0] = atk;

	//For buffs and debuffs
	Abilities brute = new Abilities("Brute",buff,dmg,"Brute");
	ab[1] = brute;
	
	//For conditions
	Abilities burn = new Abilities("Hypnosis", condition,turnLost,"Hypnotize opponent"); 
	ab[2] = burn;
        
        ultimate = new Abilities("Dream Eater", condition,trueDMG,"Enters the opponent’s dreams and does physical damage in the real world."); 
	ab[3] = ultimate;
	return ab;
           }


}