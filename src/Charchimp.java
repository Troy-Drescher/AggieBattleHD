import javax.swing.ImageIcon;
public class Charchimp extends Aggie{

	public Charchimp(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("punch",attack,"punches opponent");
		ab[0] = atk;

		Abilities brute = new Abilities("Brute",buff,dmg,"Buffs attack");
		ab[1] = brute;

		Abilities burn = new Abilities("Burn", condition,turnLost,"sets opponent on fire causing them to lose a turn"); 
		ab[2] = burn;
		
		ultimate = new Abilities("FireTail", condition,trueDMG,"sets tail on fire and hits opponent dealing true damage"); 
		ab[3] = ultimate;
		
		return ab;
	}

}
