
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author troyd
 */
public class AggieSelectListener extends JPanel implements ActionListener{
    static JButton nag = new JButton();
    static JButton pag = new JButton();
    static JButton sag = new JButton();
    static JFrame selectFrame;
    static JLabel agIMG;
    static JTextArea larea,Rarea;
    static int cAGG=0;
    static JButton nextAG,prevAG,agselStart;
    static Aggie[] AggieLists;
    static String agselAB1,agselAB2,agselAB3,agselAB4;
    static JTextArea agSelName;
    static String agselAB1t,agselAB2t,agselAB3t,agselAB4t;
    static ImageIcon ag1Icon;
    static AggieSelect2 as3;
    
    
    public void AggieSelectListener2m(AggieSelect2 as4) {
		// TODO Auto-generated constructor stub
    	as3=as4;
    	AggieLists=Main.AggieLists;
        ag1Icon=Main.ag1Icon;
    	    CompoundBorder border = new CompoundBorder(
    	        new EmptyBorder(6, 6, 6, 6),     // 6 pixels on top, left, bottom, right
    	        new LineBorder(Color.black, 1)); // outside, 1 
    	  JPanel agSbuttons = new JPanel();
    	  agSbuttons.setLayout(new GridLayout(3, 1, 10, 10));
    	  JPanel agS2buttons = new JPanel();
    	  agS2buttons.setLayout(new GridLayout(3, 1, 10, 10));
    	  JPanel agS3buttons = new JPanel();
    	  agS3buttons.setLayout(new GridLayout(3, 1, 10, 10));
    	  nextAG = new JButton("Next");
    	  prevAG = new JButton("Prev");
    	  agselStart = new JButton("Select your Aggies");
    	  nextAG.addActionListener(this);
    	  prevAG.addActionListener(this);
    	  agselStart.addActionListener(this);
    	agS2buttons.add(nextAG);
    	agS3buttons.add(agselStart);
    	agSbuttons.add(prevAG);
    	FlowLayout fl = new FlowLayout();
    	fl.setAlignment(FlowLayout.CENTER);
    	JPanel aggieImageSelection = new JPanel();
    	aggieImageSelection.setLayout(fl);

    	    agIMG = new JLabel();
    	    agIMG.setIcon(ag1Icon);
    	    agIMG.setOpaque(true);
    	    
    	//did stuff
    	JPanel agimgseltext = new JPanel();
    	  agSelName = new JTextArea("Medinasaur" + "\nStats: ATK:" + AggieLists[cAGG].getDamage() + " DEF:" +
    	AggieLists[cAGG].getDefense() +" SPD:" + AggieLists[cAGG].getSpeed() + " HP:" + AggieLists[cAGG].getMaxHP());
    	  agSelName.setEditable(false);
    	  agimgseltext.add(agSelName);

    	JPanel agselLeft = new JPanel();
    	JPanel agselright = new JPanel();
    	agselAB1 = AggieLists[cAGG].getAbilities()[0].getName();
    	agselAB2 = AggieLists[cAGG].getAbilities()[1].getName();
    	agselAB3 = AggieLists[cAGG].getAbilities()[2].getName();
    	agselAB4 = AggieLists[cAGG].getAbilities()[3].getName();
    	agselAB1t = AggieLists[cAGG].getAbilities()[0].getDesc();
    	agselAB2t = AggieLists[cAGG].getAbilities()[1].getDesc();
    	agselAB3t = AggieLists[cAGG].getAbilities()[2].getDesc();
    	agselAB4t = AggieLists[cAGG].getAbilities()[3].getDesc();
    	larea = new JTextArea();
    	larea.setText(agselAB1 + "\n" + agselAB1t + "\n\n" + agselAB2 + "\n" + agselAB2t);
    	Rarea = new JTextArea();
    	Rarea.setText(agselAB3 + "\n" + agselAB3t + "\n\n" + agselAB4 + "\n" + agselAB4t);
    	larea.setColumns(26);
    	Rarea.setColumns(26);
    	larea.setLineWrap(true);
    	Rarea.setLineWrap(true);
    	aggieImageSelection.add(larea);
    	aggieImageSelection.add(agIMG);
    	aggieImageSelection.add(Rarea);

    	Box hbox = Box.createHorizontalBox();
    	    hbox.add(Box.createHorizontalStrut(10));
    	    hbox.add(agSbuttons);
    	    hbox.add(Box.createHorizontalStrut(10));
    	    hbox.add(agS3buttons);
    	    hbox.add(Box.createHorizontalStrut(10));
    	    hbox.add(agS2buttons);
    	    hbox.add(Box.createHorizontalStrut(10));
    	Box vbox = Box.createVerticalBox();
    	    vbox.add(Box.createVerticalStrut(5));
    	    vbox.add(agimgseltext);
    	    vbox.add(Box.createVerticalStrut(5));
    	    vbox.add(aggieImageSelection);
    	Box h1box = Box.createHorizontalBox();
    	h1box.add(Box.createHorizontalStrut(10));
    	h1box.add(agselLeft);
    	h1box.add(Box.createHorizontalStrut(10));
    	Box h2box = Box.createHorizontalBox();
    	h2box.add(Box.createHorizontalStrut(10));
    	h2box.add(agselright);
    	h2box.add(Box.createHorizontalStrut(10));


    	//I DID IT
    	Container c = new Container();
    	    c.setLayout(new BorderLayout(10,5));
    	    c.add(hbox, BorderLayout.NORTH);
    	    c.add(vbox, BorderLayout.CENTER);

    	    selectFrame = new JFrame();
    			selectFrame.setSize(Main.width+400,Main.height+200);
    			selectFrame.setLocationRelativeTo(null);
    	    selectFrame.setBackground(Color.BLACK);
    	    selectFrame.add(c);
    			selectFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	    selectFrame.setResizable(true);
    	    selectFrame.setVisible(true);


    	//l

	}


	public void addActionListersAGGIE()
    {
        nag = nextAG;
        pag = prevAG;
        sag = agselStart;
        nag.addActionListener((this));
  pag.addActionListener(this);
  sag.addActionListener(this);
    }
    
    
    
    
    public void actionPerformed(ActionEvent e) {
            JButton click = (JButton)e.getSource();
    if(click == nextAG)
    {
      cAGG+=1;
      if(cAGG>AggieLists.length-1)
      {
    	  cAGG=0;
      }
      agSelName.setText(AggieLists[cAGG].getName() + "\nStats: ATK:" + AggieLists[cAGG].getDamage() + " DEF:" +
    	    	AggieLists[cAGG].getDefense() +" SPD:" + AggieLists[cAGG].getSpeed() + " HP:" + AggieLists[cAGG].getMaxHP());
      agIMG.setIcon(AggieLists[cAGG].getselIcon());
      agselAB1 = AggieLists[cAGG].getAbilities()[0].getName();
      agselAB2 = AggieLists[cAGG].getAbilities()[1].getName();
      agselAB3 = AggieLists[cAGG].getAbilities()[2].getName();
      agselAB4 = AggieLists[cAGG].getAbilities()[3].getName();
      agselAB1t = AggieLists[cAGG].getAbilities()[0].getDesc();
      agselAB2t = AggieLists[cAGG].getAbilities()[1].getDesc();
      agselAB3t = AggieLists[cAGG].getAbilities()[2].getDesc();
      agselAB4t = AggieLists[cAGG].getAbilities()[3].getDesc();
      larea.setText(agselAB1 + "\n" + agselAB1t + "\n\n" + agselAB2 + "\n" + agselAB2t);
      Rarea.setText(agselAB3 + "\n" + agselAB3t + "\n\n" + agselAB4 + "\n" + agselAB4t);

      //kl
    }
    if(click == prevAG)
    {
      cAGG= cAGG-1;
      if(cAGG<0)
      {
    	  cAGG=AggieLists.length-1;
      }
      agSelName.setText(AggieLists[cAGG].getName() + "\nStats: ATK:" + AggieLists[cAGG].getDamage() + " DEF:" +
  	    	AggieLists[cAGG].getDefense() +" SPD:" + AggieLists[cAGG].getSpeed() + " HP:" + AggieLists[cAGG].getMaxHP());
      agIMG.setIcon(AggieLists[cAGG].getselIcon());
      agselAB1 = AggieLists[cAGG].getAbilities()[0].getName();
      agselAB2 = AggieLists[cAGG].getAbilities()[1].getName();
      agselAB3 = AggieLists[cAGG].getAbilities()[2].getName();
      agselAB4 = AggieLists[cAGG].getAbilities()[3].getName();
      agselAB1t = AggieLists[cAGG].getAbilities()[0].getDesc();
      agselAB2t = AggieLists[cAGG].getAbilities()[1].getDesc();
      agselAB3t = AggieLists[cAGG].getAbilities()[2].getDesc();
      agselAB4t = AggieLists[cAGG].getAbilities()[3].getDesc();
      larea.setText(agselAB1 + "\n" + agselAB1t + "\n\n" + agselAB2 + "\n" + agselAB2t);
      Rarea.setText(agselAB3 + "\n" + agselAB3t + "\n\n" + agselAB4 + "\n" + agselAB4t);

      //kl
    }
    if(click == agselStart)
    {
      selectFrame.setVisible(false);
      selectFrame.dispose();
      as3.AggieSelect2m();

    }
    
    }
    
}
