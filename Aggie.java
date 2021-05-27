import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.ImageIcon;

public abstract class Aggie implements ActionListener{
	
	private Sprite sprite;
  private ImageIcon agIcon;
	private int xPos, yPos,size;
	private int xOrgin, yOrgin;
	
	protected final int attack = 0, //types of abilities
			buff = 1,
			debuff = 2,
			condition = 3;

	protected final int dmg = 0, // stat that is changed for buff or debuff
			spd = 1,
			def = 2;
	
	protected int turnLost = 0,
				  trueDMG = 1;
	//lt
	private final String name;
	private int damage,
				speed,
				defense,
				health;
				  
	private final int maxHealth;
	
	private JProgressBar HPbar, 
			DripBar = new JProgressBar(0,100);
	
	private int drip = 0;
	
	private JPanel panel;
	
	protected Abilities ultimate;
	
	public Aggie(Sprite sprite, int size, 
				String name, int damage, int speed, int defense, int health,ImageIcon agTIcon) {
		this.sprite = sprite;
		this.size = size;
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.defense = defense;
		this.health = health;
    agIcon = agTIcon;
		maxHealth = health;
		HPbar = new JProgressBar(0,maxHealth);
	}
	
	public String getName() {
		return name;
	}
	
	public void setHealth(int x) {
		health = x;
	}
	
  public ImageIcon getselIcon()
  {
    return agIcon;
  }

	public int getHealth() {
		return health;
	}
	
	public int getMaxHP() {
		return maxHealth;
	}
	
	public void setHealthBar() {
		HPbar.setValue(getHealth());
		HPbar.setBackground(Color.GRAY);
		HPbar.setForeground(Color.GREEN);
		HPbar.setString(getHealth() + "/" + getMaxHP() + " hp");
		HPbar.setBounds(5,25,150,15);
		HPbar.setStringPainted(true);
		HPbar.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		HPbar.setBounds(5,25,150,15);
		if(health < (double)getMaxHP()*80/100)
			HPbar.setForeground(new Color(255,243,0));
		if(health < (double)getMaxHP()*50/100)
			HPbar.setForeground((new Color(255,146,0)));
		if(health < (double)getMaxHP()*30/100)
			HPbar.setForeground((new Color(255,0,0)));
	}

	public JProgressBar getHealthBar() {
		return HPbar;
	}

	public void setDrip(int x) {
		drip = x;
	}

	public int getDrip() {
		return drip;
	}		
	

	public int getMaxDrip() {
		return 100;
	}
	
	public void setDripBar() {
		DripBar.setStringPainted(false);
		DripBar.setOpaque(true);
		DripBar.setBackground(Color.GRAY);
		DripBar.setBounds(5,40,120,10);
		DripBar.setFont(new Font("Courier",Font.BOLD,12));
		DripBar.setBorder(BorderFactory.createBevelBorder(0));
		DripBar.setValue(getDrip());
		if(getDrip() == getMaxDrip()) {
			 DripBar.setForeground(new Color(255,247,0));
		 }
		 else {
			 DripBar.setForeground(new Color(59,249,242));
		 }
	}

	public JProgressBar getDripBar() {
		// TODO Auto-generated method stub
		return DripBar;
	}
	
	public int getDamage() {
		// TODO Auto-generated method stub
		return (int)((Math.random()*(damage-(damage/3*2)) + (damage/3*2)));
	}
	
	public void setDamage(int x) {
		damage = x;
	}

	public int getMaxDamage() {
		return damage;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int x) {
		speed = x;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public void setDefense(int x) {
		defense = x;
	}
	
	public abstract Abilities [] getAbilities();
	
	public void setAbilityPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getAbilityPanel() {
		return this.panel;
	}
	
	public void animate() {
		xPos = xPos -1;
		yPos = yPos +1;
		if(xPos == xOrgin - 20)
			xPos = xOrgin;
		if(yPos == yOrgin + 5)
			yPos = yOrgin;
	}
	
	public void setXpos(int x) {
		xPos = x;
		xOrgin = x;
	}
	
	public void  setYpos(int y) {
		yPos = y;
		yOrgin = y;
	}
	
	public void render(Graphics2D g) {
		if(getMaxDrip() != getDrip()) {
			ultimate.getAbilityButton().setEnabled(false);
			ultimate.getAbilityButton().setBackground(Color.GRAY);
		}
		else {
			ultimate.getAbilityButton().setEnabled(true);
			ultimate.getAbilityButton().setBackground(Color.ORANGE);
		}
		ultimate.getAbilityButton().addActionListener(this);
		g.drawImage(sprite.getSprite(), xPos, yPos, size, size, null);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		setDrip(-20);
	}
}
