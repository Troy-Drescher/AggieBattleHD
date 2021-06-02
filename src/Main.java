import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

public class Main extends JPanel implements ActionListener{ // Add panel on side that shows each creature stats

	static JFrame frame,tableFrame;
  static boolean agselon=true;
	static final int width = 410, height = 410;

	private BufferedImage icon;
        public ClassLoader cl = this.getClass().getClassLoader();
        URL sl = cl.getResource("MedinaSaurIcon.png");
  public ImageIcon ag1Icon1 = new ImageIcon(sl);
  public ImageIcon ag2Icon1 = new ImageIcon(cl.getResource("PenisaurIcon.png"));
  public ImageIcon ag3Icon1 = new ImageIcon(cl.getResource("PegasusIcon.png"));
  public ImageIcon ag4Icon1 = new ImageIcon(cl.getResource("IceguinIcon.png"));
  public ImageIcon ag5Icon1 = new ImageIcon(cl.getResource("FinalityIcon.png"));
  public ImageIcon ag6Icon1 = new ImageIcon(cl.getResource("CharChimpIcon.png"));
  public ImageIcon ag7Icon1 = new ImageIcon(cl.getResource("StrangeCharmIcon.png"));
  public ImageIcon ag8Icon1 = new ImageIcon(cl.getResource("CorvakaIcon.png"));
  public ImageIcon ag9Icon1 = new ImageIcon(cl.getResource("AquadosIcon.png"));
  public ImageIcon ag10Icon1 = new ImageIcon(cl.getResource("GhoullyIcon.png"));
  public ImageIcon ag11Icon1 = new ImageIcon(cl.getResource("MemorraIcon.png"));
  public ImageIcon ag12Icon1 = new ImageIcon(cl.getResource("DreamReaperIcon.png"));
  public ImageIcon ag13Icon1 = new ImageIcon(cl.getResource("RafushiqiIcon.png"));
  static ImageIcon ag1Icon,ag2Icon,ag3Icon,ag4Icon,ag5Icon,ag6Icon,ag7Icon,ag8Icon,ag9Icon,ag10Icon,ag11Icon,ag12Icon,ag13Icon;
/*
  private ImageIcon ag7Icon = new ImageIcon("SportBlack.jpeg");
  private ImageIcon ag8Icon = new ImageIcon("SportBlue.jpeg");
  private ImageIcon ag9Icon = new ImageIcon("SportWhite.jpeg"); 
  */
	static Aggie p1,p2;
  static Aggie[] AggieLists;
	static JToggleButton toggle;
	private JTable table = new JTable();
	private JScrollPane container;
	static DefaultTableModel model = new DefaultTableModel();
	private Graphics2D ga;
	static Timer timer;
	static JTextField display = new JTextField();
	static String str;
	static int end;
	private static Scanner kb = new Scanner(System.in);
	public Main(String stupidstupidshit)
        {
            Main.ag1Icon=ag1Icon1;
            Main.ag2Icon=ag2Icon1;
            Main.ag3Icon=ag3Icon1;
            Main.ag4Icon=ag4Icon1;
            Main.ag5Icon=ag5Icon1;
            Main.ag6Icon=ag6Icon1;
            Main.ag7Icon=ag7Icon1;
            Main.ag8Icon=ag8Icon1;
            Main.ag9Icon=ag9Icon1;
            Main.ag10Icon=ag10Icon1;
            Main.ag11Icon=ag11Icon1;
            Main.ag12Icon=ag12Icon1;
            Main.ag13Icon=ag13Icon1;
        }
	public Main(Aggie player1, Aggie player2) {
		player1.setXpos(250);
		player1.setYpos(20);
		
		player2.setXpos(50);
		player2.setYpos(160);
		p1 = player1;
		p2 = player2;
		
		p1.setAnimations(-1, 1);
		p2.setAnimations(1, -1);
		
		setSize(width,height);  // creating panel to place on frame
		setLayout(null);
		setBackground(new Color(145,255,255));
		
		add(new BarPanel(20,40,p1)); // adds health bars
		add(new BarPanel(210,190,p2));
		
		try { // gets toggle icon
			icon = ImageIO.read(getClass().getClassLoader().getResourceAsStream("toggle.png"));
		}
		catch(Exception e) {
			System.out.println("Failed to load file");
		}
		


		
		toggle = new JToggleButton(); // adds toggle button
		toggle.setBounds(width-32,-5,icon.getWidth()-5,icon.getHeight()-5);
		toggle.setOpaque(false);
		toggle.setFocusable(false);
		toggle.setContentAreaFilled(false);
		toggle.addActionListener(this);
		toggle.setBorder(null);
		add(toggle);
		
		setTable(); // stats table
		
		tableFrame = new JFrame();// stats window
		tableFrame.setBounds(frame.getX()+width,frame.getY(),(width/3)*2,height/2);
		tableFrame.setVisible(false);
		tableFrame.setBackground(Color.BLACK);
		tableFrame.add(container);
		tableFrame.setDefaultCloseOperation(3);

		display.setFont(new Font("courier",Font.PLAIN,12));
		display.setBackground(Color.black);
		display.setEditable(false);
		display.setForeground(Color.WHITE);
		display.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
		display.setBounds(15,285,380,25);
		add(display);
		
		
		timer = new Timer(100,this);
		
	    p1.setAbilityPanel(new AttackPanel(p1,p2)); 
	    p2.setAbilityPanel(new AttackPanel(p2,p1)); 
		
	    add(p1.getAbilityPanel());
	    add(p2.getAbilityPanel());
	    
	    GameManager gm = new GameManager(p1,p2,this);
	    str = GameManager.turn.getName() + "'s turn";

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ga = (Graphics2D)g;
		ga.setStroke(new BasicStroke(1));
		ga.setColor(new Color(9,186,8));
		ga.fillOval(20, 240, 150, 40);
		ga.fillOval(220, 110, 150, 40);
		ga.setColor(Color.green);
		ga.fillOval(20, 240, 145, 35);
		ga.fillOval(220, 110, 145, 35);
		p1.render(ga);
		p2.render(ga);
		ga.drawImage(icon, width - 25, 2, icon.getWidth()/2, icon.getHeight()/2, null);
	}
	
	public static void main(String[] args){
		try {
			for(LookAndFeelInfo info:UIManager.getInstalledLookAndFeels()) {
				if(info.getName().equalsIgnoreCase("cde/motif"))
					UIManager.setLookAndFeel(info.getClassName());
			}
		}
		catch(Exception e) {}
		new Main("hello");
		// params(Sprite, name, damage, speed, defense, health)
    Aggie a1 = new Medinasaur(new Sprite("Medinasaur1.png"),"Medinasaur",50,50,50,125,ag1Icon);
    Aggie a2 = new Penisaur(new Sprite("Penisaur1.png"),"Penisaur",75,80,50,70,ag2Icon);
    Aggie a3 = new Finality(new Sprite("Finality1.png"),"Finality",125, 75,15,60,ag5Icon);
    Aggie a4 = new Charchimp(new Sprite("Charchimp1.png"),"Charchimp",100, 40, 60, 75,ag6Icon);
    Aggie a5 = new Iceguin(new Sprite("Iceguin1.png"),"Iceguin",125, 40, 35, 75,ag4Icon);
    Aggie a6 = new Pegasus(new Sprite("Pegasus1.png"),"Pegasus",70,50,70,80,ag3Icon);
    Aggie a7 = new StrangeCharm(new Sprite("StrangeCharm1.png"),"StrangeCharm",80,60,60,75,ag7Icon);
    Aggie a8 = new Corvaka(new Sprite("Corvaka1.png"),"Corvaka",45,60,70,100,ag8Icon);
    Aggie a9 = new Aquados(new Sprite("Aquados1.png"),"Aquados",75,60,65,75,ag9Icon);
    Aggie a10 = new Ghoully(new Sprite("Ghoully1.png"),"Ghoully",75,60,70,70,ag10Icon);
    Aggie a11 = new Memorra(new Sprite("Memorra1.png"),"Memorra",70,60,65,80,ag11Icon);
    Aggie a12 = new DreamReaper(new Sprite("DreamReaper1.png"),"DreamReaper",70,60,65,80,ag12Icon);
    Aggie a13 = new Rafushiqi(new Sprite("Rafushiqi1.png"),"Rafushiqi",105,60,46,64,ag13Icon);
		Aggie [] aggieList = {a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13};
		AggieLists = aggieList;
		AggieSelect2 as2 = new AggieSelect2();
		AggieSelectListener asl = new AggieSelectListener();
		asl.AggieSelectListener2m(as2);
		
			
	        
	      frame = new JFrame();
			frame.setSize(width,height);
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(true);
			

		// params(Sprite, dimX, dimY, size, name, damage, speed, defense, health)
		
		
		
    }
	
	public static void setDisplay(String text) {
		str = text;
		end = 0;
		timer.start();
	}
	
	public void setTable() {
		Object [] header = {"Stat",p1.getName(),p2.getName()};
		model.setColumnIdentifiers(header);
		model.setRowCount(5);
		model.setValueAt("Atk", 0, 0);
		model.setValueAt("Health", 1, 0);
		model.setValueAt("Drip", 2, 0);
		model.setValueAt("Spd", 3, 0);
		model.setValueAt("Def", 4, 0);
		
		updateTable();
		
		table = new JTable(model);
		table.setPreferredSize(new Dimension((width/3)*2,height/3));
		table.setShowGrid(true);
		table.setGridColor(Color.BLACK);
		table.setBackground(Color.WHITE);
		
		container = new JScrollPane(table);
		container.setPreferredSize(table.getPreferredSize());
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(end <= str.length()) {
			display.setText(str.substring(0, end));
			end++;
		}
		else {
			try {
				synchronized(timer)
				{
				    timer.wait(200);
				}
			} catch (InterruptedException e1) {}
			timer.stop();
		}
	}
	
	public static void updateTable() {
		model.setValueAt(p1.getMaxDamage(), 0, 1);
		model.setValueAt(p1.getHealth(), 1, 1);
		model.setValueAt(p1.getDrip(), 2, 1);
		model.setValueAt(p1.getSpeed(), 3, 1);
		model.setValueAt(p1.getDefense(), 4, 1);
		
		model.setValueAt(p2.getMaxDamage(), 0, 2);
		model.setValueAt(p2.getHealth(), 1, 2);
		model.setValueAt(p2.getDrip(), 2, 2);
		model.setValueAt(p2.getSpeed(), 3, 2);
		model.setValueAt(p2.getDefense(), 4, 2);
	}
}
