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
public class Rafushiqi extends Aggie{

	public Rafushiqi(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	   public Abilities [] getAbilities() {

           // for attacks
	Abilities [] ab = new Abilities[4];
	Abilities Sáqotai = new Abilities("Sáqotai", attack, "use tail like a flaming whip");
	ab[0] = Sáqotai;

	//For buffs and debuffs
	Abilities Nenságeki = new Abilities("Nenságeki", buff, dmg, "Flames grow stronger");
	ab[1] = Nenságeki;
	
	Abilities Esátcheon = new Abilities("Esátcheon", buff, def,"Cover self with wings");
	ab[2] = Esátcheon;

	ultimate = new Abilities("Coikaeru α", condition,trueDMG,"Wreath of flame that deals damage to opponent and sets Aggie’s HP to full");
	ab[3] = ultimate;

	return ab;
}



}