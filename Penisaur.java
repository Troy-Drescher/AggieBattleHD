import javax.swing.ImageIcon;
public class Penisaur extends Aggie{

	public Penisaur(Sprite sprite, int size,
					String name, int damage, int speed, int defense, int health,ImageIcon agIcon) {
		super(sprite, size, name, damage, speed, defense, health,agIcon);
	}

	@Override
	public Abilities [] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities atk = new Abilities("Tailwhip",attack, "Whips opponent with tail");
		ab[0] = atk;
		
		Abilities strength = new Abilities("harden",buff, 10,dmg, "Hardens skin, increasing strength by 10");
		ab[1] = strength;
		
		Abilities weaken = new Abilities("quicksand",debuff, 10,spd, "Sends sand at the enemy, decreasing speed by 10");
		ab[2] = weaken;
		
		ultimate = new Abilities("sheeesh",condition,turnLost, "Bamboozles opponent with a yell");
		ab[3] = ultimate;
		
		return ab;
	}

}
