public class Abilities{

	private int	type; // attack buff debuff or condition
	private String name;
	private int effect; //lost turn or true damage
	private int abilityValue;
	private int stat;
	private AbilityButton button;
	private String tooltip;
	
	public Abilities(String name, int type, int value, int stat, String tooltip) { // buff or debuff
		this.name = name;
		this.type = type;
		abilityValue = value;
		this.stat = stat;
		this.tooltip = tooltip;
	}
	
	public Abilities(String name, int type, String tooltip) { // attack
		this.name = name;
		this.type = type;
		this.tooltip = tooltip;
	}
	
	public Abilities(String name, int type, int effect, String tooltip) { //condition
		this.name = name;
		this.type = type;
		this.effect = effect;
		this.stat = effect;
		this.tooltip = tooltip;
	}
	
	public int getType() {
		return type;
	}
	
	public int getStat() {
		return stat;
	}
	public String getStatName() {
		switch(stat) {
		case 0:
			return "damage";
		case 1: 
			return "speed";
		case 2:
			return "defense";
		default: 
			return "health";
		}
	}
	
	public String getName() {
		return name;
	}
  public String getDesc() {
    return tooltip;
  }
	public int getValue() {
		return abilityValue;
	}
	
	public int getEffect() {
		return effect;
	}
	
	public void setAbilityButton(Aggie attacker, Aggie defender) {
		button = new AbilityButton(this,attacker,defender, tooltip);
	}
	
	public AbilityButton getAbilityButton() {
		return button;
	}

}

