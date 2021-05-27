
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author troyd
 */
public class AggieSelectListener implements ActionListener{
    static JButton nag = new JButton();
    static JButton pag = new JButton();
    static JButton sag = new JButton();
    public void addActionListersAGGIE()
    {
        nag = Main.nextAG;
        pag = Main.prevAG;
        sag = Main.agselStart;
        nag.addActionListener((this));
  pag.addActionListener(this);
  sag.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e) {
            JButton click = (JButton)e.getSource();
    if(click == Main.nextAG)
    {
      Main.cAGG+=1;
      Main.agSelName.setText(Main.AggieLists[Main.cAGG].getName());
      Main.agIMG.setIcon(Main.AggieLists[Main.cAGG].getselIcon());
      Main.agselAB1 = Main.AggieLists[Main.cAGG].getAbilities()[0].getName();
      Main.agselAB2 = Main.AggieLists[Main.cAGG].getAbilities()[1].getName();
      Main.agselAB3 = Main.AggieLists[Main.cAGG].getAbilities()[2].getName();
      Main.agselAB4 = Main.AggieLists[Main.cAGG].getAbilities()[3].getName();
      Main.agselAB1t = Main.AggieLists[Main.cAGG].getAbilities()[0].getDesc();
      Main.agselAB2t = Main.AggieLists[Main.cAGG].getAbilities()[1].getDesc();
      Main.agselAB3t = Main.AggieLists[Main.cAGG].getAbilities()[2].getDesc();
      Main.agselAB4t = Main.AggieLists[Main.cAGG].getAbilities()[3].getDesc();
      Main.larea.setText(Main.agselAB1 + "\n" + Main.agselAB1t + "\n\n" + Main.agselAB2 + "\n" + Main.agselAB2t);
      Main.Rarea.setText(Main.agselAB3 + "\n" + Main.agselAB3t + "\n\n" + Main.agselAB4 + "\n" + Main.agselAB4t);

      //kl
    }
    }
    
}
