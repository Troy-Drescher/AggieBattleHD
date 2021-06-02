import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.Timer;

public class AbilityButton extends JButton implements ActionListener{

	private final int attack = 0,
				buff = 1,
				debuff = 2,
				condition = 3,
				value,
				type;
	
	private final int dmg = 0,
				spd = 1,
				def = 2,
				turnLost = 3,
				trueDMG = 4,
				health = 5;
	
	private int initialDEF,initialATK,initialSPD; // defender initial stats (used for debuffs)
        private int initialDEF2,initialATK2,initialSPD2,initialHP;
	
	static int turnCounter;
	static Aggie initialAttacker;
	
	private int counter, counter2, damage;
	private boolean miss;
	private Aggie attacker,defender;
	private Abilities ability;
	private Timer timer;
	
	public AbilityButton(Abilities ability,Aggie attacker, Aggie defender, String tooltip) {
		this.setFont(new Font("dialog",Font.BOLD,10));
		this.setBackground(Color.ORANGE);
		this.setText(ability.getName().toUpperCase());
		this.addActionListener(this);
		this.setFocusable(false);
		this.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.BLUE));
		this.attacker = attacker;
		this.defender = defender;
		this.setToolTipText(tooltip);
		value = ability.getValue();
		type = ability.getType();
		this.ability = ability;
		timer = new Timer(10,this);
	}
	
	public boolean miss(float rng) { // fix chance and miss rates
		double chance =(double) (Math.random());
		System.out.println(chance);
		System.out.println(defender.getSpeed() * rng/100);
		System.out.println(rng);
		return (chance <= defender.getSpeed() * rng/100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!timer.isRunning()) {
			damage =  ((int)(attacker.getDamage() * Math.random() + (attacker.getDamage()*.30))) -
					((int)(defender.getDefense() * Math.random() + 1));
			miss = miss(.4f);
			if(damage < 10)
				damage = 10;
			initialDEF = defender.getDefense();
			initialATK = defender.getDamage();
			initialSPD = defender.getSpeed();
                        initialDEF2 = attacker.getDefense();
			initialATK2 = attacker.getDamage();
			initialSPD2 = attacker.getSpeed();
                        initialHP=attacker.getHealth();
		}
		
		attacker.getAbilityPanel().setEnabled(false);
		defender.getAbilityPanel().setEnabled(true);
		timer.start();
		switch(type) {
		case attack:
			if(!miss) {
				attack();
				attacker.animate();
				Main.setDisplay(attacker.getName() + " used " + ability.getName() + ".  It did " + damage + " damage.");
			}
			else {
				Main.setDisplay(attacker.getName() + " used " + ability.getName() + "...The attack missed.");
				Main.end = 0;
				switchTurns();
				timer.stop();
			}
			break;
		case condition:
			condition();
			break;
		case buff:
			Main.setDisplay(attacker.getName() + " used " + ability.getName() + ". " + attacker.getName() + "'s " + ability.getStatName() + " was increased");
			buff();
			break;
		case debuff:
			if(!miss) {
			Main.setDisplay(attacker.getName() + " used " + ability.getName() + ". " + defender.getName() + "'s " + ability.getStatName() + " was decreased");
			debuff();
			}
			else {
				Main.setDisplay(attacker.getName() + " used " + ability.getName() + "...The attack missed.");
				Main.end = 0;
				switchTurns();
				timer.stop();
			}
			break;
		}
	}
	
	public void condition() {
		switch(ability.getEffect()) {
		case trueDMG:
			damage = attacker.getDamage();
			System.out.println(damage);
			attack();
			attacker.animate();
			break;
		case turnLost:
			miss = miss(.4f);
			if(!miss) {
			Main.setDisplay(attacker.getName() + " used " + ability.getName() + ". " + defender.getName() + " loses its turn.");
			turnCounter = 0;
			turnCounter++;
			initialAttacker = attacker;
			timer.stop();
			}
			else {
				Main.setDisplay(attacker.getName() + " used " + ability.getName() + ". The attack missed" );
			}
				
			break;
		}
	}
	
	public void attack() {
		if(counter != damage) {
			defender.setHealth(defender.getHealth()-1);
			defender.setHealthBar();
			counter++; // damage counter
		}
		if(counter2 < 25) {
			attacker.setDrip(attacker.getDrip() + 1);
			attacker.setDripBar();
			counter2++; // drip counter
		}
		if(defender.getHealth() < 0) {
			 defender.setHealth(0);
			 defender.setHealthBar();
			 switchTurns();
			 timer.stop();
			 counter = 0;
			 counter2 = 0;
		}
		if(counter == (damage) && counter2 >= 25) {
			switchTurns();
			attacker.returnOrgin();
			timer.stop();
			counter = 0;
			counter2 = 0;
		}
		if(attacker.getDrip() > attacker.getMaxDrip()) {
			attacker.setDrip(attacker.getMaxDrip());
			attacker.setDripBar();
		}
		
	}
	
	public void buff() {
		counter++;
		if(counter > 20) {
			switchTurns();
			timer.stop();
			counter = 0;
		}
		else {
			switch(ability.getStat()){
			case dmg:
                            if(counter > initialATK2*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
                        attacker.setDamage(attacker.getMaxDamage()+1);
				break;
			case spd:
                            if(counter > initialSPD2*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
				attacker.setSpeed(attacker.getSpeed()+1);
				break;
			case def:
                            if(counter > initialDEF*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
				attacker.setDefense(attacker.getDefense()+1);
				break;
			case health:
                            if(initialHP > 100)
                            {
                            if(counter > initialHP*.2) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
				attacker.setHealth(attacker.getHealth()+1);
				attacker.setHealthBar();
                            } else
                            {
                                if(counter > initialHP*2) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
				attacker.setHealth(attacker.getHealth()+1);
				attacker.setHealthBar();
                            }
                            
			}
		}
			
	}
	
	public void debuff() {
		counter++;
		switch(ability.getStat()){
		case dmg:
			if(counter > initialATK*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			defender.setDamage(defender.getDamage()-1);
			if(defender.getDamage() <= 10) {
				switchTurns();
				defender.setDamage(10);
				timer.stop();
				counter = 0;
				break;
			}
			break;
		case spd:
			if(counter > initialSPD*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			defender.setSpeed(defender.getSpeed()-1);
			if(defender.getSpeed() <= 10) {
				switchTurns();
				defender.setSpeed(10);
				timer.stop();
				counter = 0;
				break;
			}
			break;
		case def:
			if(counter > initialDEF*.15) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			if(defender.getDefense() > 10)
				defender.setDefense(defender.getDefense()-1);
			break;
		}
			
	}
	
	public void switchTurns() {
		if(turnCounter == 0)
			GameManager.turn = defender;
		else{
			if(attacker == initialAttacker) 
				turnCounter++;
		}
		
		if(turnCounter == 3) {
			GameManager.turn = defender;
			turnCounter = 0;
		}
	}
}
