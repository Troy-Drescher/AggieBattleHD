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
public class Memorra extends Aggie{

	public Memorra(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	   public Abilities[] getAbilities() {

        // for attacks
        Abilities[] ab = new Abilities[4];
        Abilities watercannon = new Abilities("Slash", attack,"Blows in the opponent's face and deals damage");
	ab[0] = watercannon;

        Abilities chomp = new Abilities("swiftly",attack,"Memorra rushes the opponent and attacks");
	ab[1] = chomp;
        //For conditions
        Abilities suffocate = new Abilities("WindyWinds", debuff,def,"Knocks opponent of their feet");
                    ab[2] = suffocate;
                   ultimate = new Abilities("Slurp", condition,trueDMG,"Super ability, Memorrra slurps the life out of the opponent dealing big damage"); 
	ab[3] = ultimate;
	return ab;
                }

}