import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class AggieSelect2 extends JPanel implements ActionListener {
	public JToggleButton[] P1agOptions,P2agOptions;
    public JFrame select2Frame;
    public JTextField ag1,ag2;
    public JButton agsel2Start;
    public Aggie[] agList;
    public Aggie asel1,asel2;
    public AggieSelect2()
    {
    	agList=Main.AggieLists;
    	P1agOptions = new JToggleButton[agList.length];
    	P2agOptions = new JToggleButton[agList.length];
    	//l

    }
    public void AggieSelect2m()
    {
    	CompoundBorder border = new CompoundBorder(
    	        new EmptyBorder(6, 6, 6, 6),     // 6 pixels on top, left, bottom, right
    	        new LineBorder(Color.black, 1)); // outside, 1 
    	  JPanel agSbuttons = new JPanel();
    	  agSbuttons.setBorder(border);
    	  agSbuttons.setLayout(new GridLayout(agList.length+2, 1, 10, 10));
    	  JPanel agS3buttons = new JPanel();
    	  agS3buttons.setBorder(border);
    	  agS3buttons.setLayout(new GridLayout(agList.length+2, 1, 10, 10));
    	  int counter = 0;
    	  
    	  
    	  ag1 = new JTextField("Player 1 Pick Your Aggie");
    	  ag1.setEditable(false);
    	  ag2 = new JTextField("Player 2 Pick Your Aggie");
    	  ag2.setEditable(false);
    	  agSbuttons.add(ag1);
    	  agS3buttons.add(ag2);
    	  
    	  for(Aggie currentAgg : agList)
    	  {
    		  JToggleButton b1 = new JToggleButton(currentAgg.getName());
    		  b1.addActionListener(this);
    		  agSbuttons.add(b1);
    		  P1agOptions[counter]=b1;
    		  JToggleButton b2 = new JToggleButton(currentAgg.getName());
    		  b2.addActionListener(this);
    		  agS3buttons.add(b2);
    		  P2agOptions[counter]=b2;
    		  
    		  counter++;
    	  }
    	  
    	  
    	  ButtonGroup gr1 = new ButtonGroup();
    	  ButtonGroup gr2 = new ButtonGroup();
    	  for(JToggleButton b3 : P1agOptions)
    	  {
    		  gr1.add(b3);
    	  }
    	  for(JToggleButton b3 : P2agOptions)
    	  {
    		  gr2.add(b3);
    	  }
    	  
    	  
    	  agsel2Start = new JButton("Start");
    	  agsel2Start.addActionListener(this);
    	  
    	FlowLayout fl = new FlowLayout();
    	fl.setAlignment(FlowLayout.CENTER);
    	JPanel aggieImageSelection = new JPanel();
    	aggieImageSelection.setLayout(fl);
    	aggieImageSelection.add(agsel2Start);

    	    
    	//did stuff
    	JPanel agimgseltext = new JPanel();
    	  ag1 = new JTextField("Medinasaur");
    	  ag1.setEditable(false);
    	  agimgseltext.add(ag1);


    	Box hbox = Box.createHorizontalBox();
    	    hbox.add(Box.createHorizontalStrut(10));
    	    hbox.add(agSbuttons);
    	    hbox.add(Box.createHorizontalStrut(10));
    	    hbox.add(agS3buttons);
    	    hbox.add(Box.createHorizontalStrut(10));
    	Box vbox = Box.createVerticalBox();
    	    vbox.add(aggieImageSelection);
    	    vbox.add(Box.createVerticalStrut(5));


    	//I DID IT
    	Container c = new Container();
    	    c.setLayout(new BorderLayout(10,5));
    	    c.add(vbox, BorderLayout.NORTH);
    	    c.add(hbox, BorderLayout.CENTER);

    	    select2Frame = new JFrame();
    			select2Frame.setSize(Main.width+200,Main.height);
    			select2Frame.setLocationRelativeTo(null);
    	    select2Frame.setBackground(Color.BLACK);
    	    select2Frame.add(c);
    			select2Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    select2Frame.setResizable(true);
    	    select2Frame.setVisible(true);
    }
    
    public Aggie getA1()
    {
    	return asel1;
    }
    
    public Aggie getA2()
    {
    	return asel2;
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton click = null;
		try
		{
		click = (JButton)e.getSource();
		} catch(Exception abcdefghijklmnop)
		{
			
		}
		String a1N="",a2N="";
		
		for(JToggleButton b5 : P1agOptions)
		{
			if(b5.isSelected())
			{
				a1N=b5.getText();
			}
		}
		for(JToggleButton b5 : P2agOptions)
		{
			if(b5.isSelected())
			{
				a2N=b5.getText();
			}
		}
		
		if(click == agsel2Start)
		{
			
			if(a1N.equals("")||a2N.equals(""))
			{
				JOptionPane.showMessageDialog(AggieSelect2.this, "please select an Aggie");
			} else if(a1N.equals(a2N))
                        {
                            JOptionPane.showMessageDialog(AggieSelect2.this, "please select Different Aggies");
                        }else
			{
				for(Aggie ag8 : agList)
				{
					if(ag8.getName().equals(a1N))
					{
						asel1=ag8;
					}
					if(ag8.getName().equals(a2N))
					{
						asel2=ag8;
					}
				}
				Main.agselon=false;
				System.out.println("hello");
				select2Frame.setVisible(false);
				Aggie player1 = getA1();
				for(Aggie i : agList) {
					if(player1 == i)
						i.setSprite(i.getName() + "1.png" );
				}
				
				
				Aggie player2 = getA2();
				for(Aggie i : agList) {
					if(player2 == i)
						i.setSprite(i.getName() + "2.png" );
				}
				Main.frame.add(new Main(player1, player2));
				Main.frame.setVisible(true);
			}
			
		}
		
	}

}
