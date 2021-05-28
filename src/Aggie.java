import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public abstract class Aggie implements ActionListener{
	
	private Sprite sprite;
  private ImageIcon agIcon;
	private int xPos, yPos;
	protected int size;
	private int xOrgin, yOrgin;
	
	protected final int attack = 0, //types of abilities
			buff = 1,
			debuff = 2,
			condition = 3;
	
	private int xAni;
	private int yAni;

	protected final int dmg = 0, // stat that is changed for buff or debuff
			spd = 1,
			def = 2,
			turnLost = 3,
			trueDMG = 4,
			hp = 5;
	
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
	
	public Aggie(Sprite sprite, String name, int damage, int speed, int defense, int health,ImageIcon agcon) {
		this.sprite = sprite;
		size = 100;
		this.name = name;
		this.damage = damage;
		this.speed = speed;
		this.defense = defense;
		this.health = health*10;
    agIcon=agcon;
		maxHealth = health*10;
		HPbar = new JProgressBar(0,maxHealth);
	}
	public ImageIcon getselIcon()
  {
    return agIcon;
  }
	public String getName() {
		return name;
	}
	
	public void setHealth(int x) {
		health = x;
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
		return damage;
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
	
	public void setAnimations(int x, int y) {
		xAni = x;
		yAni = y;
	}
	
	public void returnOrgin() {
		xPos = xOrgin;
		yPos = yOrgin;
	}
	
	public void animate() {
		xPos = xPos + xAni;
		yPos = yPos + yAni;
		if(xPos == xOrgin + (xAni * 20))
			xPos = xOrgin;
		if(yPos == yOrgin + (yAni * 5))
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
	
	public void setSprite(String path) {
		this.sprite = new Sprite(path);
	}
	
	public void actionPerformed(ActionEvent e) {
		setDrip(-20);
	}
}
