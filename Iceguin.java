import javax.swing.ImageIcon;
public class Iceguin extends Aggie{

	public Iceguin(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agicon) {
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
		Abilities atk = new Abilities("IcyBarrage",attack,"attacks opponent with an icy barrage");
		ab[0] = atk;

		Abilities iceShot = new Abilities("IceShot",buff,hp,"Heals");
		ab[1] = iceShot;
		
		Abilities subZero = new Abilities("SubZero",debuff,spd,"chills opponent decreasing speed");
		ab[2] = subZero;

		ultimate = new Abilities("IceStorm", condition,trueDMG,"attacks an opponent with a storm of ice dealing true damage"); 
		ab[3] = ultimate;
		
		return ab;
	}

}
