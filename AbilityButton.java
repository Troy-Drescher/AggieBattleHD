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
				def = 2;
	
	private final int turnLost = 0,
					  trueDMG = 1;
	
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
	
	public boolean miss() { // fix chance and miss rates
		double chance =(double) (Math.random());
		System.out.println("Chance: " + chance + "\nSpeed: " + defender.getSpeed() * .4f/100);
		return (chance <= defender.getSpeed() * .4f/100);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(!timer.isRunning()) {
			damage = attacker.getDamage()-(int)(Math.random() * defender.getDefense() + 1);
			miss = miss();
			if(damage < 10)
				damage = 10;
		}
		
		attacker.getAbilityPanel().setEnabled(false);
		defender.getAbilityPanel().setEnabled(true);
		Main.setDisplay(attacker.getName() + " used " + ability.getName() + ". ");
		timer.start();
		switch(ability.getType()) {
		case attack:
			if(!miss) {
				attack();
				attacker.animate();
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
			buff();
			break;
		case debuff:
			debuff();
			break;
		}
	}
	
	public void condition() {
		switch(ability.getEffect()) {
		case trueDMG:
			damage = attacker.getMaxDamage() - defender.getDefense();
			attack();
			break;
		case turnLost:
			Main.setDisplay(attacker.getName() + "used " + ability.getName() + ". " + defender.getName() + " loses its turn.");
			turnCounter++;
			initialAttacker = attacker;
			timer.stop();
			break;
		}
	}
	
	public void attack() {
		counter++; // damage counter
		counter2++; // drip counter
		defender.setHealth(defender.getHealth()-1);
		defender.setHealthBar();
		if(defender.getHealth() < 0) {
			 defender.setHealth(0);
			 defender.setHealthBar();
			 switchTurns();
			 timer.stop();
			 counter = 0;
			 counter2 = 0;
		}
		if(counter2 <= 25) {
			attacker.setDrip(attacker.getDrip() + 1);
			attacker.setDripBar();
		}
		if(counter == (damage)) {
			switchTurns();
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
		switch(ability.getStat()){
		case dmg:
			if(counter > value) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			attacker.setDamage(attacker.getMaxDamage()+1);
			break;
		case spd:
			if(counter > value) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			attacker.setSpeed(attacker.getSpeed()+1);
			break;
		case def:
			if(counter > value) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			attacker.setDefense(attacker.getDefense()+1);
			break;
		}
			
	}
	
	public void debuff() {
		counter++;
		switch(ability.getStat()){
		case dmg:
			if(counter > value) {
				switchTurns();
				timer.stop();
				counter = 0;
				break;
			}
			defender.setDamage(defender.getMaxDamage()-1);
			if(defender.getMaxDamage() <= 10) {
				switchTurns();
				defender.setDamage(10);
				timer.stop();
				counter = 0;
				break;
			}
			break;
		case spd:
			if(counter > value) {
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
			if(counter > value) {
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
