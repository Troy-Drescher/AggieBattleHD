import javax.swing.ImageIcon;
public class Medinasaur extends Aggie{

	public Medinasaur(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agcon) {
		super(sprite, name, damage, speed, defense, health,agcon);
	}

	@Override
	public Abilities[] getAbilities() {
		// TODO Auto-generated method stub
		Abilities [] ab = new Abilities[4];//Name type amount stat cost
		Abilities atk = new Abilities("Cut",attack, "Cuts the opponent"); 
		ab[0] = atk;
		
		Abilities strength = new Abilities("Integrate",buff,dmg, "Increase strength");
		ab[1] = strength;
		
		Abilities weaken = new Abilities("leaf storm",debuff,def,"Decrease enemy defense with a blinding leaf storm");
		ab[2] = weaken;
		
		ultimate = new Abilities("Swamp",condition,trueDMG, "Deals true damage");
		ab[3] = ultimate;
		
		return ab;
	}

}
