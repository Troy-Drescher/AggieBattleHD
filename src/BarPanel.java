import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BarPanel extends JPanel{ 
	
	public BarPanel(int xPos, int yPos,Aggie creature) {
		this.setOpaque(true);
		this.setLayout(null);
		this.setBorder(BorderFactory.createBevelBorder(0));
		this.setBounds(xPos, yPos, 170, 65);
		this.setBackground(Color.WHITE);
		
		JLabel aggieName = new JLabel(creature.getName());
		aggieName.setFont(new Font("Courier",Font.BOLD,12));
		aggieName.setBounds(10, 5, 100, 20);
		add(aggieName);
		
		creature.setHealthBar();
		add(creature.getHealthBar());
		creature.setDripBar();
		add(creature.getDripBar());
	}

}
