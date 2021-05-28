import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class GameManager implements ActionListener{

	private Timer timer;
	private Aggie p1,p2;
	private JPanel panel;
    static int counter = 0;
	static Aggie turn;
	private boolean running;
	private Aggie winner;
	
	public GameManager(Aggie p1, Aggie p2,JPanel panel) {
		this.p1 = p1;
		this.p2 = p2;
		timer = new Timer(1,this);
		this.panel = panel;
		
		if(p2.getSpeed() > p1.getSpeed()) 
			turn = p2;
		else
			turn = p1;
		
		running = true;
		if(running)
			timer.start();
		
	}

	public void turn() {
		if(turn == p1) {
			p1.getAbilityPanel().setVisible(true);
			p2.getAbilityPanel().setVisible(false);
		}
		if(turn == p2) {
			p2.getAbilityPanel().setVisible(true);
			p1.getAbilityPanel().setVisible(false);
		}
	}
	
	public void checkStatus() {
		if(p1.getHealth() == 0 || p2.getHealth() == 0) {
			timer.stop();
			try {
				for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
					if(info.getName().equalsIgnoreCase("Metal"))
						UIManager.setLookAndFeel(info.getClassName());
				}
			}
			catch(Exception e) {}
			
			JOptionPane.showMessageDialog(panel, "Game over. " + winner.getName() + " Wins");
			panel.setEnabled(false);
			Main.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			Main.frame.dispose();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
    
		checkStatus();
		if(p1.getHealth() > p2.getHealth())
			winner = p1;
		else
			winner = p2;
		
		panel.repaint();
		if(Main.toggle.isSelected()) {
			Main.tableFrame.setVisible(true);
		}
		else
			Main.tableFrame.setVisible(false);
		
		if(!Main.timer.isRunning() && !Main.str.equals(turn.getName() + "'s turn.")) {
			Main.setDisplay(turn.getName() + "'s turn.");
		}

		turn();
		
		Main.updateTable();
	}
	
	
	
}
