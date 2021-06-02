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
public class Aquados extends Aggie{

	public Aquados(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	   public Abilities[] getAbilities() {

        // for attacks
        Abilities[] ab = new Abilities[4];
        Abilities watercannon = new Abilities("water cannon", attack,"punches opponent");
	ab[0] = watercannon;

        Abilities chomp = new Abilities("Chomp",attack,"takes a bite out of its opponent");
	ab[1] = chomp;
        //For conditions
        Abilities suffocate = new Abilities("Suffocate", condition,turnLost,"Opponent loses a turn to catch its breath");
                    ab[2] = suffocate;
                    Abilities iceBeam = new Abilities("iceBeam", condition,trueDMG,"generates three tons of ice and shoots it in a continuous beam at the opponent, severely damaging it"); 
	ab[3] = iceBeam;
	return ab;
                }

}