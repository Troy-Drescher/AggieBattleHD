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
public class DreamReaper extends Aggie{

	public DreamReaper(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	   public Abilities[] getAbilities() {

        // for attacks
        Abilities[] ab = new Abilities[4];
        Abilities watercannon = new Abilities("Slash", attack,"Dream Reaper attacks his opponent with his sickle");
	ab[0] = watercannon;

        Abilities chomp = new Abilities("chaos",attack,"Dream Repear draws power from the void and corrupts his opponent");
	ab[1] = chomp;
        //For conditions
        Abilities suffocate = new Abilities("nightmare", debuff,def,"Dream Reaper weakens his opponent with fear");
                    ab[2] = suffocate;
                   ultimate = new Abilities("super health", buff,hp,"Super ability, Dream Reaper gains 50% of remaining health"); 
	ab[3] = ultimate;
	return ab;
                }

}