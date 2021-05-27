import javax.swing.ImageIcon;
public class Pegasus extends Aggie{

	public Pegasus(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
		super(sprite, name, damage, speed, defense, health,agicon);
		// TODO Auto-generated constructor stub
		setSize();
	}

	public void setSize() {
		size = 115;
	}
	
	@Override
	public Abilities[] getAbilities() {
		Abilities [] ab = new Abilities[4];
		Abilities waterBeam = new Abilities("Water Beam",attack,"shooting another aggie with high pressure water");
		ab[0] = waterBeam;

		Abilities phychic = new Abilities("Phychic",condition,turnLost,"get into the opponent aggie's mind and create confusion which can lead the opponent aggie to lose attack");
		ab[1] = phychic;

		Abilities speedyDragon = new Abilities("Speedy Dragon",buff,spd,"buffing to prevent from getting attack and attack in retaliation");
		ab[2] = speedyDragon;

		ultimate = new Abilities("Power Heal", buff, hp, "heal"); 
		ab[3] = ultimate;

		
		return ab;
	}

}
