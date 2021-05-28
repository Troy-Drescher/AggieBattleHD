import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class AttackPanel extends JPanel{

	public AttackPanel(Aggie p1, Aggie p2) {
		setBounds(15,310,380,70);
		setBackground(Color.WHITE);
		setOpaque(true);
		setLayout(new GridLayout(2,2,2,2));
		setBorder(BorderFactory.createCompoundBorder(BorderFactory.createBevelBorder(0),
				  BorderFactory.createBevelBorder(1)));

		for(Abilities x:p1.getAbilities()) {
			x.setAbilityButton(p1, p2);
			add(x.getAbilityButton());
		}
		
		p1.setAbilityPanel(this);
		
	}
	
}
