import javax.swing.ImageIcon;
public class Finality extends Aggie{

	public Finality(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Abilities[] getAbilities() {
		// TODO Auto-generated method stub
		Abilities [] ab = new Abilities[4];
		Abilities end = new Abilities("End",attack, "Slashes the opponent.");
		ab[0] = end;
		
		Abilities lacerate = new Abilities("Lacerate", debuff, dmg, "Decreases opponents attack.");
		ab[1] = lacerate;

		Abilities overpower = new Abilities("Overpower", buff, dmg, "Increases attack.");
		ab[2] = overpower;

		ultimate = new Abilities("Soul Slash",condition,trueDMG, "Deals true damage");
    	ab[3] = ultimate;
		
		return ab;
	}
	
}
